import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Kitchen extends ClockDomain{
  public Kitchen(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal lightStatus = new Signal("lightStatus", Signal.OUTPUT);
  public Signal humanPresenceStatus = new Signal("humanPresenceStatus", Signal.OUTPUT);
  public Signal lightIntensityValue = new Signal("lightIntensityValue", Signal.OUTPUT);
  private Signal isLightON_1;
  private Signal isHumanPresent_1;
  private Signal lightIntensity_1;
  private boolean temp_thread_3;//test.sysj line: 10, column: 4
  private boolean temp_thread_6;//test.sysj line: 28, column: 4
  private double temp_thread_9;//test.sysj line: 44, column: 4
  private boolean temp_thread_4;//test.sysj line: 16, column: 4
  private boolean temp_thread_7;//test.sysj line: 34, column: 4
  private double temp_thread_10;//test.sysj line: 50, column: 4
  private int S26 = 1;
  private int S7 = 1;
  private int S2 = 1;
  private int S1 = 1;
  private int S5 = 1;
  private int S15 = 1;
  private int S13 = 1;
  private int S23 = 1;
  private int S21 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread82(int [] tdone, int [] ends){
        active[11]=0;
    ends[11]=0;
    tdone[11]=1;
  }

  public void thread80(int [] tdone, int [] ends){
        switch(S21){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(lightIntensity_1.getprestatus()){//test.sysj line: 49, column: 10
          temp_thread_10 = ((double)lightIntensity_1.getpreval());//test.sysj line: 50, column: 4
          System.out.println("Light Intensity: " + temp_thread_10);//test.sysj line: 51, column: 4
          lightIntensityValue.setPresent();//test.sysj line: 52, column: 4
          currsigs.addElement(lightIntensityValue);
          lightIntensityValue.setValue(temp_thread_10);//test.sysj line: 52, column: 4
          System.out.println("Emitted lightIntensityValue");
          S21=0;
          active[10]=0;
          ends[10]=0;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread79(int [] tdone, int [] ends){
        active[9]=0;
    ends[9]=0;
    tdone[9]=1;
  }

  public void thread78(int [] tdone, int [] ends){
        switch(S23){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        lightIntensity_1.setClear();//test.sysj line: 42, column: 3
        thread79(tdone,ends);
        thread80(tdone,ends);
        int biggest81 = 0;
        if(ends[9]>=biggest81){
          biggest81=ends[9];
        }
        if(ends[10]>=biggest81){
          biggest81=ends[10];
        }
        if(biggest81 == 1){
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        //FINXME code
        if(biggest81 == 0){
          S23=0;
          active[8]=0;
          ends[8]=0;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread76(int [] tdone, int [] ends){
        switch(S13){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(isHumanPresent_1.getprestatus()){//test.sysj line: 33, column: 10
          temp_thread_7 = ((boolean)isHumanPresent_1.getpreval());//test.sysj line: 34, column: 4
          System.out.println("Human Presence: " + temp_thread_7);//test.sysj line: 35, column: 4
          humanPresenceStatus.setPresent();//test.sysj line: 36, column: 4
          currsigs.addElement(humanPresenceStatus);
          humanPresenceStatus.setValue(temp_thread_7);//test.sysj line: 36, column: 4
          System.out.println("Emitted humanPresenceStatus");
          S13=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread75(int [] tdone, int [] ends){
        active[6]=0;
    ends[6]=0;
    tdone[6]=1;
  }

  public void thread74(int [] tdone, int [] ends){
        switch(S15){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        isHumanPresent_1.setClear();//test.sysj line: 24, column: 3
        thread75(tdone,ends);
        thread76(tdone,ends);
        int biggest77 = 0;
        if(ends[6]>=biggest77){
          biggest77=ends[6];
        }
        if(ends[7]>=biggest77){
          biggest77=ends[7];
        }
        if(biggest77 == 1){
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        //FINXME code
        if(biggest77 == 0){
          S15=0;
          active[5]=0;
          ends[5]=0;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread72(int [] tdone, int [] ends){
        switch(S5){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(isLightON_1.getprestatus()){//test.sysj line: 15, column: 10
          temp_thread_4 = ((boolean)isLightON_1.getpreval());//test.sysj line: 16, column: 4
          System.out.println("Light status: " + temp_thread_4);//test.sysj line: 17, column: 4
          lightStatus.setPresent();//test.sysj line: 18, column: 4
          currsigs.addElement(lightStatus);
          lightStatus.setValue(temp_thread_4);//test.sysj line: 18, column: 4
          System.out.println("Emitted lightStatus");
          S5=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread71(int [] tdone, int [] ends){
        switch(S2){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1){
        }
        break;
      
    }
  }

  public void thread70(int [] tdone, int [] ends){
        switch(S7){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        isLightON_1.setClear();//test.sysj line: 8, column: 3
        thread71(tdone,ends);
        thread72(tdone,ends);
        int biggest73 = 0;
        if(ends[3]>=biggest73){
          biggest73=ends[3];
        }
        if(ends[4]>=biggest73){
          biggest73=ends[4];
        }
        if(biggest73 == 1){
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        //FINXME code
        if(biggest73 == 0){
          S7=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread68(int [] tdone, int [] ends){
        active[11]=0;
    ends[11]=0;
    tdone[11]=1;
  }

  public void thread66(int [] tdone, int [] ends){
        S21=1;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread65(int [] tdone, int [] ends){
        temp_thread_9 = 3.66;//test.sysj line: 44, column: 4
    lightIntensity_1.setPresent();//test.sysj line: 45, column: 4
    currsigs.addElement(lightIntensity_1);
    lightIntensity_1.setValue(temp_thread_9);//test.sysj line: 45, column: 4
    System.out.println("Emitted lightIntensity_1");
    active[9]=0;
    ends[9]=0;
    tdone[9]=1;
  }

  public void thread64(int [] tdone, int [] ends){
        S23=1;
    lightIntensity_1.setClear();//test.sysj line: 42, column: 3
    thread65(tdone,ends);
    thread66(tdone,ends);
    int biggest67 = 0;
    if(ends[9]>=biggest67){
      biggest67=ends[9];
    }
    if(ends[10]>=biggest67){
      biggest67=ends[10];
    }
    if(biggest67 == 1){
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread62(int [] tdone, int [] ends){
        S13=1;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread61(int [] tdone, int [] ends){
        temp_thread_6 = true;//test.sysj line: 28, column: 4
    isHumanPresent_1.setPresent();//test.sysj line: 29, column: 4
    currsigs.addElement(isHumanPresent_1);
    isHumanPresent_1.setValue(temp_thread_6);//test.sysj line: 29, column: 4
    System.out.println("Emitted isHumanPresent_1");
    active[6]=0;
    ends[6]=0;
    tdone[6]=1;
  }

  public void thread60(int [] tdone, int [] ends){
        S15=1;
    isHumanPresent_1.setClear();//test.sysj line: 24, column: 3
    thread61(tdone,ends);
    thread62(tdone,ends);
    int biggest63 = 0;
    if(ends[6]>=biggest63){
      biggest63=ends[6];
    }
    if(ends[7]>=biggest63){
      biggest63=ends[7];
    }
    if(biggest63 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread58(int [] tdone, int [] ends){
        S5=1;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread57(int [] tdone, int [] ends){
        S2=1;
    temp_thread_3 = false;//test.sysj line: 10, column: 4
    isLightON_1.setPresent();//test.sysj line: 11, column: 4
    currsigs.addElement(isLightON_1);
    isLightON_1.setValue(temp_thread_3);//test.sysj line: 11, column: 4
    System.out.println("Emitted isLightON_1");
    S2=0;
    active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread56(int [] tdone, int [] ends){
        S7=1;
    isLightON_1.setClear();//test.sysj line: 8, column: 3
    thread57(tdone,ends);
    thread58(tdone,ends);
    int biggest59 = 0;
    if(ends[3]>=biggest59){
      biggest59=ends[3];
    }
    if(ends[4]>=biggest59){
      biggest59=ends[4];
    }
    if(biggest59 == 1){
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S26){
        case 0 : 
          S26=0;
          break RUN;
        
        case 1 : 
          S26=2;
          S26=2;
          thread56(tdone,ends);
          thread60(tdone,ends);
          thread64(tdone,ends);
          thread68(tdone,ends);
          int biggest69 = 0;
          if(ends[2]>=biggest69){
            biggest69=ends[2];
          }
          if(ends[5]>=biggest69){
            biggest69=ends[5];
          }
          if(ends[8]>=biggest69){
            biggest69=ends[8];
          }
          if(ends[11]>=biggest69){
            biggest69=ends[11];
          }
          if(biggest69 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread70(tdone,ends);
          thread74(tdone,ends);
          thread78(tdone,ends);
          thread82(tdone,ends);
          int biggest83 = 0;
          if(ends[2]>=biggest83){
            biggest83=ends[2];
          }
          if(ends[5]>=biggest83){
            biggest83=ends[5];
          }
          if(ends[8]>=biggest83){
            biggest83=ends[8];
          }
          if(ends[11]>=biggest83){
            biggest83=ends[11];
          }
          if(biggest83 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest83 == 0){
            S26=0;
            active[1]=0;
            ends[1]=0;
            S26=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    isLightON_1 = new Signal();
    isHumanPresent_1 = new Signal();
    lightIntensity_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          df = true;
        }
        runClockDomain();
      }
      lightStatus.setpreclear();
      humanPresenceStatus.setpreclear();
      lightIntensityValue.setpreclear();
      isLightON_1.setpreclear();
      isHumanPresent_1.setpreclear();
      lightIntensity_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      lightStatus.sethook();
      lightStatus.setClear();
      humanPresenceStatus.sethook();
      humanPresenceStatus.setClear();
      lightIntensityValue.sethook();
      lightIntensityValue.setClear();
      isLightON_1.setClear();
      isHumanPresent_1.setClear();
      lightIntensity_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
      }
      runFinisher();
      if(active[1] == 0){
      	System.out.println("Finished CD");
      }
      if(!threaded) break;
    }
  }
}
