package SignalThreads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.systemj.ipc.GenericSignalReceiver;
import com.systemj.ipc.ObjectInputWorker;

public class KitchenHumanPresenceReceiver extends GenericSignalReceiver
{
	protected InetAddress address;
	protected int port;
	protected ServerSocket serverSocket = null;
	protected ExecutorService es = Executors.newCachedThreadPool();
	protected final static int SO_TIMEOUT = 500;
	
	@Override
	public void configure(Hashtable/*<String, String>*/ data) throws RuntimeException
	{
		if(data.containsKey("127.0.0.1"))
		{
			try
			{
				address = InetAddress.getByName((String)data.get("127.0.0.1"));
			}
			catch (UnknownHostException e)
			{
				throw new RuntimeException("Unknown host: " + data.get("127.0.0.1"), e);
			}
		}
		else
		{
			throw new RuntimeException("The configuration parameter 'IP' is required!");
		}
		if(data.containsKey("10001"))
		{
			port = Integer.parseInt((String)data.get("10001"));
		}
		else
		{
			throw new RuntimeException("The configuration parameter 'Port' is required!");
		} 
		if(data.containsKey("humanPresenceStatus")){
			this.name = (String)data.get("humanPresenceStatus");
		}
		else
			throw new RuntimeException("Signal name is missing in LCF");
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port, 50, address);
			serverSocket.setSoTimeout(SO_TIMEOUT);
			Socket socket = null;
			while (!interrupted) {
				try {
					socket = serverSocket.accept();
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					es.submit(new ObjectInputWorker(this, ois, socket));
				} catch (SocketTimeoutException e) {
				} catch (IOException ee){
					if (socket != null)
						socket.close();
				}
			}
			es.shutdownNow();
			es.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
				shutdown = true;
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	@Override
	public void getBuffer(Object[] obj)
	{
		
	}

	public KitchenHumanPresenceReceiver(){
		super(); // Initializes the buffer
	}

	@Override
	public boolean isShutDown() {
		return shutdown;
	}
}
