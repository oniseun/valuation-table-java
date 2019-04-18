package hello;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;







public class Valuaxion
  extends MIDlet
  implements CommandListener
{
  public Form Start;
  public Form pvForm;
  public Form A1Form;
  public Form YPSForm;
  public Form YPDForm;
  public Form YPPForm;
  public Form AboutForm;
  public TextField pvYrs;
  public TextField pvRate;
  public TextField aYrs;
  public TextField aRate;
  public TextField YPSYrs;
  public TextField YPSRate;
  public TextField YPDYrs;
  public TextField YPDRate;
  public TextField YPDsf;
  public TextField YPDtx;
  public TextField YPPRate;
  public Ticker tiker;
  public Command cmdSubmit;
  public Command acmdSubmit;
  public Command YPScmdSubmit;
  
  public Valuaxion() {}
  
  public void selectOption()
  {
    Select = new Command("Select", 1, 0);
    ExitBtn = new Command("Exit", 2, 1);
    tiker = new Ticker("This Software was developed by Oni Victor");
    Menu = new List("SELECT CATEGORY", 3);
    Menu.append("Present Value", null);
    Menu.append("Amount Of #1", null);
    Menu.append("YP (Single Rate)", null);
    Menu.append("YP (Dual Rate)", null);
    Menu.append("YP (in Perpetuity)", null);
    Menu.append("About this app", null);
    Menu.setTicker(tiker);
    Menu.addCommand(Select);
    Menu.addCommand(ExitBtn);
    Menu.setSelectCommand(Select);
    Menu.setCommandListener(this);
    display = Display.getDisplay(this);
    display.setCurrent(Menu);
  }
  
  public void about() {
    AboutForm = new Form("About this Software");
    AboutForm.append("This Software was developed by Oni Victor, its a freeware and therefore not to be sold \n Visit www.valuason.tk to download the app");
    
    setFormDisplay(AboutForm);
  }
  

  public void pv()
  {
    pvYrs = new TextField("Number Of Year(s) ", null, 2, 2);
    pvRate = new TextField("Interest Rate ", null, 3, 5);
    pvAns = new StringItem("PV =", "");
    cmdSubmit = new Command("Calculate", 1, 0);
    backBtn = new Command("Main Menu", 2, 1);
    Start = new Form("Present Value of #1");
    

    Start.append(pvYrs);
    Start.append(pvRate);
    Start.append(pvAns);
    Start.addCommand(cmdSubmit);
    Start.addCommand(backBtn);
    Start.setCommandListener(this);
    
    setFormDisplay(Start);
  }
  

  public void YPS()
  {
    YPSYrs = new TextField("Number Of Year(s) ", null, 2, 2);
    YPSRate = new TextField("Interest Rate ", null, 3, 5);
    YPSAns = new StringItem("Years Purchase =", "");
    YPScmdSubmit = new Command("Calculate", 1, 0);
    backBtn = new Command("Main Menu", 2, 1);
    YPSForm = new Form("Years Purchase Single Rate ");
    

    YPSForm.append(YPSYrs);
    YPSForm.append(YPSRate);
    YPSForm.append(YPSAns);
    YPSForm.addCommand(YPScmdSubmit);
    YPSForm.addCommand(backBtn);
    YPSForm.setCommandListener(this);
    
    setFormDisplay(YPSForm);
  }
  

  public void YPD()
  {
    YPDYrs = new TextField("Number Of Year(s) ", null, 2, 2);
    YPDRate = new TextField("Interest Rate ", null, 3, 5);
    YPDsf = new TextField("YPD sinking Fund Rate ", null, 3, 5);
    YPDtx = new TextField("Tax ", null, 2, 2);
    YPDAns = new StringItem("YP Dual Rate is =", "");
    YPDcmdSubmit = new Command("Calculate", 1, 0);
    backBtn = new Command("Main Menu", 2, 1);
    YPDForm = new Form("YP Dual Rate");
    

    YPDForm.append(YPDYrs);
    YPDForm.append(YPDRate);
    YPDForm.append(YPDsf);
    YPDForm.append(YPDtx);
    YPDForm.append(YPDAns);
    YPDForm.addCommand(YPDcmdSubmit);
    YPDForm.addCommand(backBtn);
    YPDForm.setCommandListener(this);
    
    setFormDisplay(YPDForm);
  }
  


  public void YPP()
  {
    YPPRate = new TextField("Interest Rate ", null, 3, 5);
    YPPAns = new StringItem("YP In Perp is =", "");
    YPPcmdSubmit = new Command("Calculate", 1, 0);
    backBtn = new Command("Main Menu", 2, 1);
    YPPForm = new Form("YP in Perpetuity  ");
    


    YPPForm.append(YPPRate);
    YPPForm.append(YPPAns);
    YPPForm.addCommand(YPPcmdSubmit);
    YPPForm.addCommand(backBtn);
    YPPForm.setCommandListener(this);
    
    setFormDisplay(YPPForm);
  }
  




  public void Amtof1()
  {
    aYrs = new TextField("Number Of Year(s) ", null, 2, 2);
    aRate = new TextField("Interest Rate ", null, 3, 5);
    aAns = new StringItem("Amount of #1=", "");
    acmdSubmit = new Command("Calculate", 1, 0);
    backBtn = new Command("Main Menu", 2, 1);
    A1Form = new Form("Amount of #1");
    

    A1Form.append(aYrs);
    A1Form.append(aRate);
    A1Form.append(aAns);
    A1Form.addCommand(acmdSubmit);
    A1Form.addCommand(backBtn);
    A1Form.setCommandListener(this);
    
    setFormDisplay(A1Form);
  }
  




  public float A(float i, float n)
  {
    i /= 100.0F;
    float A = pow(1.0F + i, n);
    return A;
  }
  
  public float A2(float i, float sf, float A)
  {
    i /= 100.0F;sf /= 100.0F;
    float a2 = i + sf / (A - 1.0F);
    return a2;
  }
  


  public float pv(float i, float n)
  {
    float A = pow(1.0F + i / 100.0F, n);
    float str = 1.0F / A;
    float result = str;
    return result;
  }
  
  public String substr(String str, int start, int end) {
    char[] data = str.toCharArray();
    String Result = String.valueOf(data, start, end);
    return Result;
  }
  
  public void calcpv() {
    try { String PVR = pvRate.getString();
      String PVY = pvYrs.getString();
      i = Float.parseFloat(PVR);
      n = Float.parseFloat(PVY);
      float str = pv(i, n);
      String Result = substr(Float.toString(str), 0, 9);
      pvAns.setText(Result);
    } catch (Exception e) {
      pvAns.setText("Error::");
    } }
  
  public void calcYPS() { try { String PVR = YPSRate.getString();
      String PVY = YPSYrs.getString();
      i = (Float.parseFloat(PVR) / 100.0F);
      n = Float.parseFloat(PVY);
      float pv = pv(i, n);
      String YPS = Float.toString(pv);
      String Result = substr(YPS, 0, 4);
      YPSAns.setText(Result);
    } catch (Exception e) {
      YPSAns.setText("Error::");
    } }
  
  public void calcYPD() { try { String PVR = YPDRate.getString();
      String PVY = YPDYrs.getString();
      sf = Float.parseFloat(YPDsf.getString());
      tx = Float.parseFloat(YPDtx.getString());
      i = Float.parseFloat(PVR);
      n = Float.parseFloat(PVY);
      float A = A(sf, n);
      float YPD = 1.0F / A2(i, sf, A);
      String data = Float.toString(YPD);
      String Result = substr(data, 0, 7);
      YPDAns.setText(Result);
    } catch (Exception e) {
      YPDAns.setText("Error::");
    } }
  
  public void calcYPP() { try { String PVR = YPPRate.getString();
      i = (Float.parseFloat(PVR) / 100.0F);
      float str = 1.0F / i;
      String Result = Float.toString(str);
      YPPAns.setText(Result);
    } catch (Exception e) {
      YPPAns.setText("Error::");
    }
  }
  
  public void calcA1() { try { String PVR = aRate.getString();
      String PVY = aYrs.getString();
      i = Float.parseFloat(PVR);
      n = Float.parseFloat(PVY);
      double A = pow(1.0F + i / 100.0F, n);
      
      String data = Double.toString(A);
      String Result = substr(data, 0, 9);
      aAns.setText(Result);
    } catch (Exception e) {
      aAns.setText("Error::");
    }
  }
  
  public void startApp() throws MIDletStateChangeException { selectOption(); }
  
  public void pauseApp() {}
  
  public void destroyApp(boolean unconditional) {}
  
  public void commandAction(Command c, Displayable d) {
    if (c == cmdSubmit) {
      calcpv();
    }
    else if (c == acmdSubmit) {
      calcA1();
    }
    else if (c == YPScmdSubmit) {
      calcYPS();
    }
    else if (c == YPDcmdSubmit) {
      calcYPD();
    }
    else if (c == YPPcmdSubmit) {
      calcYPP();
    }
    else if (c == Select) {
      int s = Menu.getSelectedIndex();
      switch (s) {
      case 0:  pv(); break;
      case 1:  Amtof1(); break;
      case 2:  YPS(); break;
      case 3:  YPD(); break;
      case 4:  YPP(); break;
      case 5:  about();
      


      }
      
    }
    else if (c == backBtn)
    {
      display = Display.getDisplay(this);
      display.setCurrent(Menu);
    }
    else {
      destroyApp(true);
      notifyDestroyed();
    }
  }
  
  public Command YPDcmdSubmit;
  public Command YPPcmdSubmit;
  public Command Select;
  public Command backBtn;
  public Command ExitBtn;
  
  public static float pow(float a, float b) {
    int x = (int)(Double.doubleToLongBits(a) >> 32);
    int y = (int)(b * (x - 1072632447) + 1.07263245E9F);
    String str = Double.toString(Double.longBitsToDouble(y << 32));
    float ans = Float.parseFloat(str);
    return ans; }
  
  public float n;
  
  public void setFormDisplay(Form displayer) { Display display = Display.getDisplay(this);
    display.setCurrent(displayer);
  }
  
  public float i;
  public float An;
  public float Ai;
  public float YPDn;
  public float YPDi;
  public float sf;
  public float tx;
  public float YPSn;
  public float YPSi;
  public float YPPi;
  public Display display;
  public StringItem pvAns;
  public StringItem aAns;
  public StringItem YPDAns;
  public StringItem YPSAns;
  public StringItem YPPAns;
  public List Menu;
}
