/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import javax.microedition.media.MediaException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.RecordControl;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author ernestoexposito
 */
public class HelloMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private String DBNAME = "AudioDataBase";
    private RecordStore rs = null;
    private int lastRecord = 1;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command okCommand;
    private Command okCommand1;
    private Command playAudio;
    private Command backCommand;
    private Command playAudio1;
    private Command backCommand1;
    private Command capture;
    private Command play;
    private Command captureAudio;
    private Command sendAudio;
    private Form form;
    private StringItem stringItem;
    private TextField pw;
    private StringItem stringItem1;
    private TextField login;
    private Alert alert;
    private Form audioPlayer;
    private StringItem stringItem2;
    private Form AudioCapture;
    private StringItem stringItem3;
    private StringItem stringItem4;
    private StringItem stringItem5;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The HelloMIDlet constructor.
     */
    public HelloMIDlet() {
        try {
            rs = RecordStore.openRecordStore(DBNAME, true);
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
    // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
    // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == AudioCapture) {//GEN-BEGIN:|7-commandAction|1|48-preAction
            if (command == backCommand1) {//GEN-END:|7-commandAction|1|48-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|2|48-postAction
            // write post-action user code here
            } else if (command == capture) {//GEN-LINE:|7-commandAction|3|46-preAction
                try {
                    Player p = Manager.createPlayer("capture://audio?encoding=pcm");
                    p.realize();
                    RecordControl rc = (RecordControl) p.getControl("RecordControl");
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    rc.setRecordStream(output);
                    rc.startRecord();
                    p.start();
                    getStringItem3().setText("recording...");
                    Thread.currentThread().sleep(10000);
                    getStringItem3().setText("done!");
                    rc.commit();
                    byte[] recordedData = output.toByteArray();
                    p.close();
                    rs.addRecord(recordedData, 0, recordedData.length);
                // write post-action user code here
                } catch (Exception ex) {
                    getStringItem3().setText(ex.toString());
                }
//GEN-LINE:|7-commandAction|4|46-postAction
            // write post-action user code here
            } else if (command == play) {//GEN-LINE:|7-commandAction|5|52-preAction
                try {
                    if (lastRecord > rs.getNumRecords() && lastRecord != 1) {
                        lastRecord = 1;
                    }
                    if (lastRecord <= rs.getNumRecords()) {
                        byte[] recordedData = rs.getRecord(lastRecord++);
                        getStringItem3().setText("playing - No:" + lastRecord + " / size:" + rs.getNumRecords());
                        ByteArrayInputStream recordedInputStream = new ByteArrayInputStream(recordedData);
                        Player p = Manager.createPlayer(recordedInputStream, "audio/basic");
                        p.prefetch();
                        p.start();
                    }
                // write post-action user code here
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//GEN-LINE:|7-commandAction|6|52-postAction
            // write post-action user code here
            } else if (command == sendAudio) {//GEN-LINE:|7-commandAction|7|58-preAction
                try {
                    byte[] recordedData = null;
                    if (rs.getNumRecords() > 0) {
                        try {
                            getStringItem5().setText("retrieving record to send");
                            recordedData = rs.getRecord(rs.getNumRecords());
                        } catch (RecordStoreException ex) {
                            getStringItem5().setText(ex.toString());
                        }
                    }
                    if (recordedData != null) {
                        try {
                            SocketConnection sc = (SocketConnection) Connector.open("socket://192.168.1.22:10000");
                            DataInputStream is = sc.openDataInputStream();

                            int l = is.readInt();
                            byte[] b = new byte[l];
                            getStringItem5().setText("sending record data/reading command of " + l);
                            //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                            //DocumentBuilder builder = factory.newDocumentBuilder();
                            //Document document = builder.parse(is);
                            //Element e = document.getDocumentElement();
                            //= (Element) document.getFirstChild();
                            //getStringItem5().setText(" root:" + e.toString());
                            is.read(b);
                            getStringItem5().setText(" ready! read:" + b.length);
                            DataOutputStream os = sc.openDataOutputStream();
                            os.writeInt(recordedData.length);
                            //os.flush();
                            os.write(recordedData);
                            os.flush();
                            Thread.currentThread().sleep(5000);
                            getStringItem5().setText(" ready! sent!!");
                            os.close();
                            is.close();
                            sc.close();
                        // write post-action user code here
                        } catch (Exception ex) {
                            getStringItem5().setText(ex.toString());
                        }
                    // write post-action user code here
                    }
                // write post-action user code here
                } catch (RecordStoreNotOpenException ex) {
                    getStringItem5().setText(ex.toString());
                }
//GEN-LINE:|7-commandAction|8|58-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|39-preAction
        } else if (displayable == audioPlayer) {
            if (command == backCommand) {//GEN-END:|7-commandAction|9|39-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|7-commandAction|10|39-postAction
            // write post-action user code here
            } else if (command == playAudio1) {//GEN-LINE:|7-commandAction|11|37-preAction
                try {
                    getStringItem2().setText("playing!");
                    Player p = Manager.createPlayer("http://homepages.laas.fr/eexposit/insa/mmedia/UntilTheEnd.mp3");
                    //p.setLoopCount(5);
                    p.start();
                // write post-action user code here
                } catch (IOException ex) {
                    getStringItem2().setText(ex.toString());
                } catch (MediaException ex) {
                    getStringItem2().setText(ex.toString());
                }

//GEN-LINE:|7-commandAction|12|37-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|55-preAction
        } else if (displayable == form) {
            if (command == captureAudio) {//GEN-END:|7-commandAction|13|55-preAction
                // write pre-action user code here
                switchDisplayable(null, getAudioCapture());//GEN-LINE:|7-commandAction|14|55-postAction
            // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|15|19-preAction
                try {
                    rs.closeRecordStore();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                exitMIDlet();//GEN-LINE:|7-commandAction|16|19-postAction
            // write post-action user code here
            } else if (command == okCommand1) {//GEN-LINE:|7-commandAction|17|29-preAction
                try {
                    //J2MEServiceService_Stub service = new J2MEServiceService_Stub();
                    //boolean res = service.connection(getLogin().getString(), getPw().getString());
                    //getStringItem().setText("Result and trying : " + res);

                    SocketConnection sc = (SocketConnection) Connector.open("socket://192.168.1.22:10000");
                    DataInputStream is = sc.openDataInputStream();
                    //byte[] b = new byte[2000];
                    int l = is.readInt();
                    getStringItem1().setText("trying connection/reading command of:" + l);

                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(is);
                    Element e = document.getDocumentElement();
                    //= (Element) document.getFirstChild();
                    getStringItem1().setText(" root:" + e.toString());
                    DataOutputStream os = sc.openDataOutputStream();
                    os.writeInt(3);
                    os.flush();
                    os.write(new String("bye").getBytes());
                    os.flush();
                    os.close();
                    is.close();
                    sc.close();

                } catch (Exception ex) {
                    getStringItem().setText(ex.toString() + ex.getMessage());
                }
                switchDisplayable(getAlert(), getForm());//GEN-LINE:|7-commandAction|18|29-postAction
            // write post-action user code here
            } else if (command == playAudio) {//GEN-LINE:|7-commandAction|19|34-preAction
                // write pre-action user code here
                switchDisplayable(null, getAudioPlayer());//GEN-LINE:|7-commandAction|20|34-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|7-postCommandAction
        }//GEN-END:|7-commandAction|21|7-postCommandAction
// write post-action user code here
    }//GEN-BEGIN:|7-commandAction|22|
    //</editor-fold>//GEN-END:|7-commandAction|22|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
        // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            form = new Form("Welcome", new Item[] { getLogin(), getPw(), getStringItem(), getStringItem1() });//GEN-BEGIN:|14-getter|1|14-postInit
            form.addCommand(getExitCommand());
            form.addCommand(getOkCommand1());
            form.addCommand(getPlayAudio());
            form.addCommand(getCaptureAudio());
            form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
        // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|22-getter|1|22-postInit
        // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: pw ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of pw component.
     * @return the initialized component instance
     */
    public TextField getPw() {
        if (pw == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            pw = new TextField("password", "enter your password", 32, TextField.ANY);//GEN-LINE:|24-getter|1|24-postInit
        // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return pw;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|25-getter|0|25-preInit
            // write pre-init user code here
            stringItem = new StringItem("Result", "");//GEN-LINE:|25-getter|1|25-postInit
        // write post-init user code here
        }//GEN-BEGIN:|25-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|25-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: login ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of login component.
     * @return the initialized component instance
     */
    public TextField getLogin() {
        if (login == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            login = new TextField("login", "enter your login", 32, TextField.ANY);//GEN-LINE:|26-getter|1|26-postInit
        // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return login;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|27-getter|0|27-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("Result1", null);//GEN-LINE:|27-getter|1|27-postInit
        // write post-init user code here
        }//GEN-BEGIN:|27-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|27-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            okCommand1 = new Command("Connections", Command.OK, 0);//GEN-LINE:|28-getter|1|28-postInit
        // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            alert = new Alert("alert", "Done!!", null, null);//GEN-BEGIN:|30-getter|1|30-postInit
            alert.setTimeout(Alert.FOREVER);//GEN-END:|30-getter|1|30-postInit
        // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: playAudio ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initiliazed instance of playAudio component.
     * @return the initialized component instance
     */
    public Command getPlayAudio() {
        if (playAudio == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
            playAudio = new Command("player", Command.ITEM, 0);//GEN-LINE:|33-getter|1|33-postInit
        // write post-init user code here
        }//GEN-BEGIN:|33-getter|2|
        return playAudio;
    }
    //</editor-fold>//GEN-END:|33-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: audioPlayer ">//GEN-BEGIN:|32-getter|0|32-preInit
    /**
     * Returns an initiliazed instance of audioPlayer component.
     * @return the initialized component instance
     */
    public Form getAudioPlayer() {
        if (audioPlayer == null) {//GEN-END:|32-getter|0|32-preInit
            // write pre-init user code here
            audioPlayer = new Form("form1", new Item[] { getStringItem2() });//GEN-BEGIN:|32-getter|1|32-postInit
            audioPlayer.addCommand(getPlayAudio1());
            audioPlayer.addCommand(getBackCommand());
            audioPlayer.setCommandListener(this);//GEN-END:|32-getter|1|32-postInit
        // write post-init user code here
        }//GEN-BEGIN:|32-getter|2|
        return audioPlayer;
    }
    //</editor-fold>//GEN-END:|32-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: playAudio1 ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of playAudio1 component.
     * @return the initialized component instance
     */
    public Command getPlayAudio1() {
        if (playAudio1 == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            playAudio1 = new Command("play", Command.OK, 0);//GEN-LINE:|36-getter|1|36-postInit
        // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return playAudio1;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|38-getter|1|38-postInit
        // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|43-getter|0|43-preInit
    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {//GEN-END:|43-getter|0|43-preInit
            // write pre-init user code here
            stringItem2 = new StringItem("state", null);//GEN-LINE:|43-getter|1|43-postInit
        // write post-init user code here
        }//GEN-BEGIN:|43-getter|2|
        return stringItem2;
    }
    //</editor-fold>//GEN-END:|43-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: capture ">//GEN-BEGIN:|45-getter|0|45-preInit
    /**
     * Returns an initiliazed instance of capture component.
     * @return the initialized component instance
     */
    public Command getCapture() {
        if (capture == null) {//GEN-END:|45-getter|0|45-preInit
            // write pre-init user code here
            capture = new Command("capture", Command.OK, 0);//GEN-LINE:|45-getter|1|45-postInit
        // write post-init user code here
        }//GEN-BEGIN:|45-getter|2|
        return capture;
    }
    //</editor-fold>//GEN-END:|45-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|47-getter|0|47-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|47-getter|0|47-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|47-getter|1|47-postInit
        // write post-init user code here
        }//GEN-BEGIN:|47-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|47-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: AudioCapture ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of AudioCapture component.
     * @return the initialized component instance
     */
    public Form getAudioCapture() {
        if (AudioCapture == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            AudioCapture = new Form("form1", new Item[] { getStringItem3(), getStringItem4(), getStringItem5() });//GEN-BEGIN:|44-getter|1|44-postInit
            AudioCapture.addCommand(getCapture());
            AudioCapture.addCommand(getBackCommand1());
            AudioCapture.addCommand(getPlay());
            AudioCapture.addCommand(getSendAudio());
            AudioCapture.setCommandListener(this);//GEN-END:|44-getter|1|44-postInit
        // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return AudioCapture;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|50-getter|0|50-preInit
    /**
     * Returns an initiliazed instance of stringItem3 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {//GEN-END:|50-getter|0|50-preInit
            // write pre-init user code here
            stringItem3 = new StringItem("press capture to record audio", null);//GEN-LINE:|50-getter|1|50-postInit
        // write post-init user code here
        }//GEN-BEGIN:|50-getter|2|
        return stringItem3;
    }
    //</editor-fold>//GEN-END:|50-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: play ">//GEN-BEGIN:|51-getter|0|51-preInit
    /**
     * Returns an initiliazed instance of play component.
     * @return the initialized component instance
     */
    public Command getPlay() {
        if (play == null) {//GEN-END:|51-getter|0|51-preInit
            // write pre-init user code here
            play = new Command("play", Command.OK, 0);//GEN-LINE:|51-getter|1|51-postInit
        // write post-init user code here
        }//GEN-BEGIN:|51-getter|2|
        return play;
    }
    //</editor-fold>//GEN-END:|51-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|53-getter|0|53-preInit
    /**
     * Returns an initiliazed instance of stringItem4 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {//GEN-END:|53-getter|0|53-preInit
            // write pre-init user code here
            stringItem4 = new StringItem("press play to play captured audio", null);//GEN-LINE:|53-getter|1|53-postInit
        // write post-init user code here
        }//GEN-BEGIN:|53-getter|2|
        return stringItem4;
    }
    //</editor-fold>//GEN-END:|53-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: captureAudio ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of captureAudio component.
     * @return the initialized component instance
     */
    public Command getCaptureAudio() {
        if (captureAudio == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            captureAudio = new Command("capture", Command.OK, 0);//GEN-LINE:|54-getter|1|54-postInit
        // write post-init user code here
        }//GEN-BEGIN:|54-getter|2|
        return captureAudio;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: sendAudio ">//GEN-BEGIN:|57-getter|0|57-preInit
    /**
     * Returns an initiliazed instance of sendAudio component.
     * @return the initialized component instance
     */
    public Command getSendAudio() {
        if (sendAudio == null) {//GEN-END:|57-getter|0|57-preInit
            // write pre-init user code here
            sendAudio = new Command("sendAudio", Command.OK, 0);//GEN-LINE:|57-getter|1|57-postInit
        // write post-init user code here
        }//GEN-BEGIN:|57-getter|2|
        return sendAudio;
    }
    //</editor-fold>//GEN-END:|57-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem5 ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of stringItem5 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem5() {
        if (stringItem5 == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            stringItem5 = new StringItem("press sendAudio to send audio", null);//GEN-LINE:|59-getter|1|59-postInit
        // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return stringItem5;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable(null, null);
        destroyApp(true);
        notifyDestroyed();

    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();

        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }
}
