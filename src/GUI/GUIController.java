package GUI;

import Archives.ZipFiles;
import Encryption.CipherEncoder;
import Encryption.CipherFileEncoder;
import ReadingAndWriting.FileTypes.ReadingFromJson;
import ReadingAndWriting.FileTypes.ReadingFromTxt;
import ReadingAndWriting.FileTypes.ReadingFromXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GUIController {
    public MenuButton Encryption;
    public MenuButton Archiving;
    public MenuItem Archive;
    public MenuItem Unarchive;
    public MenuItem Encrypt;
    public MenuItem Decrypt;
    public MenuItem TxtR;
    public MenuItem JsonR;
    public MenuItem XMLR;
    public MenuItem TxtW;
    public MenuItem JsonW;
    public MenuItem XMLW;
    public MenuButton Writing;
    public MenuButton Reading;
    public MenuButton EncryptionS;
    public MenuItem EncryptS;
    public MenuItem DecryptS;

    public void ArchEncReadFile(int event) {

        TextField text = new TextField("Enter path to your file");
        StackPane.setAlignment(text, Pos.TOP_CENTER);

        Button btn = new Button("Action");
        StackPane secondaryLayout = new StackPane(text, btn);

        btn.setOnAction(e -> {
            if (event == 1)
                new ZipFiles().archive(text.getText());
            if (event == 2)
                new ZipFiles().unarchive(text.getText());
            if (event == 3) {
                try {
                    CipherFileEncoder.encryptFile("1234567890123456", new File(text.getText()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (event == 4) {
                try {
                    CipherFileEncoder.decryptFile("1234567890123456", new File(text.getText()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (event == 5) {
                try {
                    ReadingFromTxt rft = new ReadingFromTxt();
                    rft.read(text.getText());
                    Label l = new Label(rft.result);
                    StackPane.setAlignment(l, Pos.BOTTOM_CENTER);
                    secondaryLayout.getChildren().add(l);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (event == 6) {
                try {
                    ReadingFromJson rfj = new ReadingFromJson();
                    rfj.read(text.getText());
                    Label l = new Label(rfj.result);
                    StackPane.setAlignment(l, Pos.BOTTOM_CENTER);
                    secondaryLayout.getChildren().add(l);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (event == 7) {
                try {
                    ReadingFromXML rfx = new ReadingFromXML();
                    rfx.read(text.getText());
                    Label l = new Label(rfx.result);
                    StackPane.setAlignment(l, Pos.BOTTOM_CENTER);
                    secondaryLayout.getChildren().add(l);
                } catch (IOException | ParserConfigurationException | SAXException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Scene secondScene = new Scene(secondaryLayout, 400, 200);
        Stage newWindow = new Stage();
        newWindow.setTitle("Next Stage");
        newWindow.setScene(secondScene);

        newWindow.show();
    }

    public void WriteString(int event) {

        TextField text = new TextField("Enter path to your file.");
        StackPane.setAlignment(text, Pos.TOP_CENTER);

        TextField text_str = new TextField("Enter your string.");

        Button btn = new Button("Action");
        StackPane.setAlignment(text, Pos.BOTTOM_CENTER);
        StackPane secondaryLayout = new StackPane(text, text_str, btn);

        btn.setOnAction(e -> {
            if (event == 1) {
                try {
                    new ReadingFromTxt().write(text.getText(), text_str.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (event == 2) {
                try {
                    new ReadingFromJson().write(text.getText(), text_str.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (event == 3) {
                try {
                    new ReadingFromXML().write(text.getText(), text_str.getText());
                } catch (ParserConfigurationException | TransformerException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Scene secondScene = new Scene(secondaryLayout, 400, 100);
        Stage newWindow = new Stage();
        newWindow.setTitle("Next Stage");
        newWindow.setScene(secondScene);

        newWindow.show();
    }

    public void EncString(int event) {

        TextField text = new TextField("Enter your string.");
        StackPane.setAlignment(text, Pos.TOP_CENTER);

        Button btn = new Button("Action");
        StackPane secondaryLayout = new StackPane(text, btn);

        btn.setOnAction(e -> {
            if(event == 1) {
                try {
                    CipherEncoder.encrypt("1234567890123456", text.getText());
                } catch (NoSuchPaddingException | InvalidKeyException | BadPaddingException |
                         IllegalBlockSizeException | NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (event == 2) {
                try {
                    CipherEncoder.decrypt("1234567890123456", text.getText());
                } catch (NoSuchPaddingException | BadPaddingException | NoSuchAlgorithmException |
                         IllegalBlockSizeException | InvalidKeyException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Scene secondScene = new Scene(secondaryLayout, 400, 100);
        Stage newWindow = new Stage();
        newWindow.setTitle("Next Stage");
        newWindow.setScene(secondScene);

        newWindow.show();
    }

    public void ArchiveMethod() {
        ArchEncReadFile(1);
    }

    public void UnarchiveMethod() {
        ArchEncReadFile(2);
    }

    public void EncryptMethod() {
        ArchEncReadFile(3);
    }

    public void DecryptMethod() {
        ArchEncReadFile(4);
    }

    public void TxtRead() {
        ArchEncReadFile(5);
    }

    public void JsonRead() {
        ArchEncReadFile(6);
    }

    public void XMLRead() {
        ArchEncReadFile(7);
    }
    public void TxtWrite() {
        WriteString(1);
    }

    public void JsonWrite() {
        WriteString(2);
    }

    public void XMLWrite() {
        WriteString(3);
    }


    public void EncryptString() {
        EncString(1);
    }

    public void DecryptString() {
        EncString(2);
    }
}
