import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class KitchenController extends ClockDomain{
  public KitchenController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal humanPresenceStatus = new Signal("humanPresenceStatus", Signal.INPUT);
  public Signal lightIntensityValue = new Signal("lightIntensityValue", Signal.INPUT);
  public Signal lightStatus = new Signal("lightStatus", Signal.INPUT);
  private Signal humanPresence_12;
  private Signal lightState_12;
  private Signal lightIntensity_12;
  private boolean temp_thread_14;//test.sysj line: 70, column: 4
  private double temp_thread_15;//test.sysj line: 77, column: 4
  private boolean temp_thread_16;//test.sysj line: 84, column: 4
  private boolean temp_humanPresence_thread_17;//test.sysj line: 91, column: 4
  private boolean temp_lightStatus_thread_17;//test.sysj line: 92, column: 4
  private double temp_lightIntensity_thread_17;//test.sysj line: 93, column: 4
  private double LIGHT_INTENSITY_LIMIT_thread_17;//test.sysj line: 94, column: 4
  private int S54 = 1;
  private int S51 = 1;
  private int S32 = 1;
  private int S35 = 1;
  private int S38 = 1;
  private int S49 = 1;
  private int S41 = 1;
  private int S44 = 1;
  private int S47 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread106(int [] tdone, int [] ends){
        active[21]=0;
    ends[21]=0;
    tdone[21]=1;
  }

  public void thread103(int [] tdone, int [] ends){
        switch(S47){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(lightState_12.getprestatus()){//test.sysj line: 90, column: 62
          S47=0;
          active[20]=0;
          ends[20]=0;
          tdone[20]=1;
        }
        else {
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread102(int [] tdone, int [] ends){
        switch(S44){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(lightIntensity_12.getprestatus()){//test.sysj line: 90, column: 36
          S44=0;
          active[19]=0;
          ends[19]=0;
          tdone[19]=1;
        }
        else {
          active[19]=1;
          ends[19]=1;
          tdone[19]=1;
        }
        break;
      
    }
  }

  public void thread101(int [] tdone, int [] ends){
        switch(S41){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(humanPresence_12.getprestatus()){//test.sysj line: 90, column: 11
          S41=0;
          active[18]=0;
          ends[18]=0;
          tdone[18]=1;
        }
        else {
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        break;
      
    }
  }

  public void thread100(int [] tdone, int [] ends){
        switch(S49){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        thread101(tdone,ends);
        thread102(tdone,ends);
        thread103(tdone,ends);
        int biggest104 = 0;
        if(ends[18]>=biggest104){
          biggest104=ends[18];
        }
        if(ends[19]>=biggest104){
          biggest104=ends[19];
        }
        if(ends[20]>=biggest104){
          biggest104=ends[20];
        }
        if(biggest104 == 1){
          active[17]=1;
          ends[17]=1;
          tdone[17]=1;
        }
        //FINXME code
        if(biggest104 == 0){
          temp_humanPresence_thread_17 = ((boolean)humanPresence_12.getpreval());//test.sysj line: 91, column: 4
          temp_lightStatus_thread_17 = ((boolean)lightState_12.getpreval());//test.sysj line: 92, column: 4
          temp_lightIntensity_thread_17 = ((double)lightIntensity_12.getpreval());//test.sysj line: 93, column: 4
          LIGHT_INTENSITY_LIMIT_thread_17 = 20.3;//test.sysj line: 94, column: 4
          if(temp_humanPresence_thread_17 == false && temp_lightStatus_thread_17 == true) {//test.sysj line: 96, column: 4
            System.out.println("Switch off light:kitchen");//test.sysj line: 97, column: 5
          }
          else {//test.sysj line: 95, column: 4
            if(temp_humanPresence_thread_17 == true && temp_lightIntensity_thread_17 < LIGHT_INTENSITY_LIMIT_thread_17 && temp_lightStatus_thread_17 == false) {//test.sysj line: 100, column: 4
              System.out.println("Switch on light to increase brightness:kitchen");//test.sysj line: 101, column: 5
            }
            else {//test.sysj line: 99, column: 9
              if(temp_humanPresence_thread_17 == true && temp_lightIntensity_thread_17 >= LIGHT_INTENSITY_LIMIT_thread_17 && temp_lightStatus_thread_17 == true) {//test.sysj line: 104, column: 4
                System.out.println("Light Intensity is high. Switch off light to save energy:kitchen");//test.sysj line: 105, column: 5
              }
            }
          }
          S49=0;
          active[17]=0;
          ends[17]=0;
          tdone[17]=1;
        }
        break;
      
    }
  }

  public void thread99(int [] tdone, int [] ends){
        switch(S38){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if(lightStatus.getprestatus()){//test.sysj line: 83, column: 10
          temp_thread_16 = ((Boolean)lightStatus.getpreval());//test.sysj line: 84, column: 4
          System.out.println("Con:Light status: " + temp_thread_16);//test.sysj line: 85, column: 4
          lightState_12.setPresent();//test.sysj line: 86, column: 4
          currsigs.addElement(lightState_12);
          lightState_12.setValue(temp_thread_16);//test.sysj line: 86, column: 4
          System.out.println("Emitted lightState_12");
          S38=0;
          active[16]=0;
          ends[16]=0;
          tdone[16]=1;
        }
        else {
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        break;
      
    }
  }

  public void thread98(int [] tdone, int [] ends){
        switch(S35){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(lightIntensityValue.getprestatus()){//test.sysj line: 76, column: 10
          temp_thread_15 = ((Double)lightIntensityValue.getpreval());//test.sysj line: 77, column: 4
          System.out.println("Con:Light In: " + temp_thread_15);//test.sysj line: 78, column: 4
          lightIntensity_12.setPresent();//test.sysj line: 79, column: 4
          currsigs.addElement(lightIntensity_12);
          lightIntensity_12.setValue(temp_thread_15);//test.sysj line: 79, column: 4
          System.out.println("Emitted lightIntensity_12");
          S35=0;
          active[15]=0;
          ends[15]=0;
          tdone[15]=1;
        }
        else {
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        break;
      
    }
  }

  public void thread97(int [] tdone, int [] ends){
        switch(S32){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        if(humanPresenceStatus.getprestatus()){//test.sysj line: 69, column: 10
          temp_thread_14 = ((Boolean)humanPresenceStatus.getpreval());//test.sysj line: 70, column: 4
          System.out.println("Con:Hum Pre: " + temp_thread_14);//test.sysj line: 71, column: 4
          humanPresence_12.setPresent();//test.sysj line: 72, column: 4
          currsigs.addElement(humanPresence_12);
          humanPresence_12.setValue(temp_thread_14);//test.sysj line: 72, column: 4
          System.out.println("Emitted humanPresence_12");
          S32=0;
          active[14]=0;
          ends[14]=0;
          tdone[14]=1;
        }
        else {
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        break;
      
    }
  }

  public void thread96(int [] tdone, int [] ends){
        switch(S51){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        humanPresence_12.setClear();//test.sysj line: 66, column: 3
        lightState_12.setClear();//test.sysj line: 66, column: 3
        lightIntensity_12.setClear();//test.sysj line: 67, column: 3
        thread97(tdone,ends);
        thread98(tdone,ends);
        thread99(tdone,ends);
        thread100(tdone,ends);
        int biggest105 = 0;
        if(ends[14]>=biggest105){
          biggest105=ends[14];
        }
        if(ends[15]>=biggest105){
          biggest105=ends[15];
        }
        if(ends[16]>=biggest105){
          biggest105=ends[16];
        }
        if(ends[17]>=biggest105){
          biggest105=ends[17];
        }
        if(biggest105 == 1){
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        //FINXME code
        if(biggest105 == 0){
          S51=0;
          active[13]=0;
          ends[13]=0;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread94(int [] tdone, int [] ends){
        active[21]=0;
    ends[21]=0;
    tdone[21]=1;
  }

  public void thread91(int [] tdone, int [] ends){
        S47=1;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread90(int [] tdone, int [] ends){
        S44=1;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread89(int [] tdone, int [] ends){
        S41=1;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread88(int [] tdone, int [] ends){
        S49=1;
    thread89(tdone,ends);
    thread90(tdone,ends);
    thread91(tdone,ends);
    int biggest92 = 0;
    if(ends[18]>=biggest92){
      biggest92=ends[18];
    }
    if(ends[19]>=biggest92){
      biggest92=ends[19];
    }
    if(ends[20]>=biggest92){
      biggest92=ends[20];
    }
    if(biggest92 == 1){
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
  }

  public void thread87(int [] tdone, int [] ends){
        S38=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread86(int [] tdone, int [] ends){
        S35=1;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread85(int [] tdone, int [] ends){
        S32=1;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread84(int [] tdone, int [] ends){
        S51=1;
    humanPresence_12.setClear();//test.sysj line: 66, column: 3
    lightState_12.setClear();//test.sysj line: 66, column: 3
    lightIntensity_12.setClear();//test.sysj line: 67, column: 3
    thread85(tdone,ends);
    thread86(tdone,ends);
    thread87(tdone,ends);
    thread88(tdone,ends);
    int biggest93 = 0;
    if(ends[14]>=biggest93){
      biggest93=ends[14];
    }
    if(ends[15]>=biggest93){
      biggest93=ends[15];
    }
    if(ends[16]>=biggest93){
      biggest93=ends[16];
    }
    if(ends[17]>=biggest93){
      biggest93=ends[17];
    }
    if(biggest93 == 1){
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S54){
        case 0 : 
          S54=0;
          break RUN;
        
        case 1 : 
          S54=2;
          S54=2;
          thread84(tdone,ends);
          thread94(tdone,ends);
          int biggest95 = 0;
          if(ends[13]>=biggest95){
            biggest95=ends[13];
          }
          if(ends[21]>=biggest95){
            biggest95=ends[21];
          }
          if(biggest95 == 1){
            active[12]=1;
            ends[12]=1;
            break RUN;
          }
        
        case 2 : 
          thread96(tdone,ends);
          thread106(tdone,ends);
          int biggest107 = 0;
          if(ends[13]>=biggest107){
            biggest107=ends[13];
          }
          if(ends[21]>=biggest107){
            biggest107=ends[21];
          }
          if(biggest107 == 1){
            active[12]=1;
            ends[12]=1;
            break RUN;
          }
          //FINXME code
          if(biggest107 == 0){
            S54=0;
            active[12]=0;
            ends[12]=0;
            S54=0;
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
    humanPresence_12 = new Signal();
    lightState_12 = new Signal();
    lightIntensity_12 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[12] != 0){
      int index = 12;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[12]!=0 || suspended[12]!=0 || active[12]!=1);
      else{
        if(!df){
          humanPresenceStatus.gethook();
          lightIntensityValue.gethook();
          lightStatus.gethook();
          df = true;
        }
        runClockDomain();
      }
      humanPresenceStatus.setpreclear();
      lightIntensityValue.setpreclear();
      lightStatus.setpreclear();
      humanPresence_12.setpreclear();
      lightState_12.setpreclear();
      lightIntensity_12.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = humanPresenceStatus.getStatus() ? humanPresenceStatus.setprepresent() : humanPresenceStatus.setpreclear();
      humanPresenceStatus.setpreval(humanPresenceStatus.getValue());
      humanPresenceStatus.setClear();
      dummyint = lightIntensityValue.getStatus() ? lightIntensityValue.setprepresent() : lightIntensityValue.setpreclear();
      lightIntensityValue.setpreval(lightIntensityValue.getValue());
      lightIntensityValue.setClear();
      dummyint = lightStatus.getStatus() ? lightStatus.setprepresent() : lightStatus.setpreclear();
      lightStatus.setpreval(lightStatus.getValue());
      lightStatus.setClear();
      humanPresence_12.setClear();
      lightState_12.setClear();
      lightIntensity_12.setClear();
      if(paused[12]!=0 || suspended[12]!=0 || active[12]!=1);
      else{
        humanPresenceStatus.gethook();
        lightIntensityValue.gethook();
        lightStatus.gethook();
      }
      runFinisher();
      if(active[12] == 0){
      	System.out.println("Finished CD");
      }
      if(!threaded) break;
    }
  }
}
