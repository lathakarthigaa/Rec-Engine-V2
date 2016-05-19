package SignalThreads;

import static com.systemj.Utils.log;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;

import com.systemj.ipc.GenericSignalSender;

public class KitchenLightIntensitySender extends GenericSignalSender {

	protected InetAddress address;
	protected int port;
	protected Socket client = null;
	ObjectOutputStream os;
	private Object preval;

	enum STATE {
		ABSENT, PRESENT, UNKNOWN
	}

	STATE st = STATE.UNKNOWN;

	@Override
	public void configure(Hashtable/* <String, String> */ data) throws RuntimeException {
		if (data.containsKey("IP")) {
			try {
				address = InetAddress.getByName((String) data.get("127.0.0.1"));
			} catch (UnknownHostException e) {
				throw new RuntimeException("Unknown host: " + data.get("127.0.0.1"), e);
			}
		} else {
			throw new RuntimeException("The configuration parameter 'IP' is required!");
		}
		
		if (data.containsKey("10002")) {
			port = Integer.parseInt((String) data.get("10002"));
		} else {
			throw new RuntimeException("The configuration parameter 'Port' is required!");
		}
		
		if (data.containsKey("lightIntensityValue")) {
			this.name = (String) data.get("lightIntensityValue");
		} else
			throw new RuntimeException("Signal name is missing in LCF");

		client = new Socket();
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void run() {
		if (super.buffer.length > 1) {
			if ((super.buffer[1] != preval && !super.buffer[1].equals(preval)) || st != STATE.PRESENT)
				send(STATE.PRESENT);
		} else
			send(STATE.PRESENT);
	}

	protected void send(STATE toSet) {
		try {
			os.reset();
			os.writeObject(super.buffer);
			if (super.buffer.length > 1)
				preval = super.buffer[1];
			st = toSet;
		} catch (IOException e) {
			closeSocket(client);
			st = STATE.UNKNOWN;
		}
	}
	
	public void closeSocket(Socket s){
		if(s != null){
			try {
				s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public boolean setup(Object[] obj) {
		try {
			if (client.isClosed()) {
				client = new Socket();
				client.connect(new InetSocketAddress(address, port), 50);
				OutputStream oos = client.getOutputStream();
				os = new ObjectOutputStream(oos);
			}
		} catch (java.net.SocketTimeoutException | ConnectException e) {
			// This means there is no listener
			closeSocket(client);
			return false;
		} catch (Exception e) {
			// Any other unexpected exceptions
			e.printStackTrace();
			closeSocket(client);
			return false;
		}

		super.buffer = obj;
		return true;
	}

	static Object[] SIG_ABSENT = new Object[] { Boolean.FALSE };

	@Override
	public void arun() {
		if (st != STATE.ABSENT) {
			if (this.setup(SIG_ABSENT)) {
				send(STATE.ABSENT);
			}
		}
	}

	@Override
	public void cleanUp() {
		if (client != null) {
			closeSocket(client);
		}
		log.info("Client shutdown " + address + " " + port +" "+this);
	}
}
