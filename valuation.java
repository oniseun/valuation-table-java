import javax.microedition.lcdui.TextField;

public class Valuaxion extends javax.microedition.midlet.MIDlet implements javax.microedition.lcdui.CommandListener { public javax.microedition.lcdui.Form Start;
  public javax.microedition.lcdui.Form pvForm;
  public javax.microedition.lcdui.Form A1Form;
  public javax.microedition.lcdui.Form YPSForm;
  public javax.microedition.lcdui.Form YPDForm;
  public javax.microedition.lcdui.Form YPPForm;
  public javax.microedition.lcdui.Form AboutForm;
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
  public javax.microedition.lcdui.Ticker tiker;
  public javax.microedition.lcdui.Command cmdSubmit;
  public javax.microedition.lcdui.Command acmdSubmit;
  public javax.microedition.lcdui.Command YPScmdSubmit;
  public javax.microedition.lcdui.Command YPDcmdSubmit;
  public javax.microedition.lcdui.Command YPPcmdSubmit;
  public javax.microedition.lcdui.Command Select;
  public javax.microedition.lcdui.Command backBtn;
  public javax.microedition.lcdui.Command ExitBtn;
  public float n;
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
  public javax.microedition.lcdui.Display display;
  public javax.microedition.lcdui.StringItem pvAns;
  public javax.microedition.lcdui.StringItem aAns;
  public javax.microedition.lcdui.StringItem YPDAns;
  public javax.microedition.lcdui.StringItem YPSAns;
  public javax.microedition.lcdui.StringItem YPPAns;
  public javax.microedition.lcdui.List Menu;
  
  public Valuaxion() {}
  
  public void selectOption() { Select = new javax.microedition.lcdui.Command("Select", 1, 0);
    ExitBtn = new javax.microedition.lcdui.Command("Exit", 2, 1);
    tiker = new javax.microedition.lcdui.Ticker("This Software was developed by Oni Victor");
    Menu = new javax.microedition.lcdui.List("SELECT CATEGORY", 3);
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
    display = javax.microedition.lcdui.Display.getDisplay(this);
    display.setCurrent(Menu);
  }
  
  public void about() {
    AboutForm = new javax.microedition.lcdui.Form("About this Software");
    backBtn = new javax.microedition.lcdui.Command("Main Menu", 2, 1);
    AboutForm.addCommand(backBtn);
    AboutForm.append("This Software was developed by Oni Victor, its a freeware and therefore not to be sold \n Visit www.valuason.tk to download the app");
    
    setFormDisplay(AboutForm);
    AboutForm.setCommandListener(this);
  }
  

  public void pv()
  {
    pvYrs = new TextField("Number Of Year(s) ", null, 2, 2);
    pvRate = new TextField("Interest Rate ", null, 3, 5);
    pvAns = new javax.microedition.lcdui.StringItem("PV =", "");
    cmdSubmit = new javax.microedition.lcdui.Command("Calculate", 1, 0);
    backBtn = new javax.microedition.lcdui.Command("Main Menu", 2, 1);
    Start = new javax.microedition.lcdui.Form("Present Value of #1");
    

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
    YPSAns = new javax.microedition.lcdui.StringItem("Years Purchase =", "");
    YPScmdSubmit = new javax.microedition.lcdui.Command("Calculate", 1, 0);
    backBtn = new javax.microedition.lcdui.Command("Main Menu", 2, 1);
    YPSForm = new javax.microedition.lcdui.Form("Years Purchase Single Rate ");
    

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
    YPDAns = new javax.microedition.lcdui.StringItem("YP Dual Rate is =", "");
    YPDcmdSubmit = new javax.microedition.lcdui.Command("Calculate", 1, 0);
    backBtn = new javax.microedition.lcdui.Command("Main Menu", 2, 1);
    YPDForm = new javax.microedition.lcdui.Form("YP Dual Rate");
    

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
    YPPAns = new javax.microedition.lcdui.StringItem("YP In Perp is =", "");
    YPPcmdSubmit = new javax.microedition.lcdui.Command("Calculate", 1, 0);
    backBtn = new javax.microedition.lcdui.Command("Main Menu", 2, 1);
    YPPForm = new javax.microedition.lcdui.Form("YP in Perpetuity  ");
    


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
    aAns = new javax.microedition.lcdui.StringItem("Amount of #1=", "");
    acmdSubmit = new javax.microedition.lcdui.Command("Calculate", 1, 0);
    backBtn = new javax.microedition.lcdui.Command("Main Menu", 2, 1);
    A1Form = new javax.microedition.lcdui.Form("Amount of #1");
    

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
    i /= 100.0F;
    sf /= 100.0F;
    A -= 1.0F;
    sf /= A;
    float a2 = i + sf;
    float ans = 1.0F / a2;
    return ans;
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
      float YPD = A2(i, sf, A);
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
  
  public void startApp() throws javax.microedition.midlet.MIDletStateChangeException { selectOption(); }
  
  public void pauseApp() {}
  
  public void destroyApp(boolean unconditional) {}
  
  public void commandAction(javax.microedition.lcdui.Command c, javax.microedition.lcdui.Displayable d) {
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
      display = javax.microedition.lcdui.Display.getDisplay(this);
      display.setCurrent(Menu);
    }
    else {
      destroyApp(true);
      notifyDestroyed();
    }
  }
  







  public float pow(float str, float power)
  {
    float t = 1.0F;
    for (i = 1.0F; i <= power; i += 1.0F) t *= str;
    return t;
  }
  
  public void setFormDisplay(javax.microedition.lcdui.Form displayer) {
    javax.microedition.lcdui.Display display = javax.microedition.lcdui.Display.getDisplay(this);
    display.setCurrent(displayer);
  }
}