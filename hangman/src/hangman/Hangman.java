/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author TA NI
 */
/*
 the class Hangman with a inner class GameClass does main functions parsing word from WordFile class.
 */
public class Hangman {

    /*
     *this is the constructor method which initialize two boolian variables
     *this method call initComponents method
     */
    public Hangman() {
        soundVarOn = false;
        soundVarOff = true;

        initComponents();
    }

    /**
     * this initComponents() method declares all necessary GUI components
     */

    private void initComponents() {
        /**
         * declaration of components
         */
        Frame = new JFrame();
        soundLayer = new JPanel();
        SoundBox = new JCheckBox();
        NewGameButton = new JButton();
        InstructionsButton = new JButton();
        CreditButton = new JButton();
        ExitButton = new JButton();
        MainPanel = new JPanel();
        FrontImageLabel = new JLabel();
        GamePanel = new JPanel();
        GamePanelColorImageLabel = new JLabel();
        A = new JButton();
        B = new JButton();
        C = new JButton();
        D = new JButton();
        E = new JButton();
        F = new JButton();
        G = new JButton();
        H = new JButton();
        I = new JButton();
        J = new JButton();
        K = new JButton();
        L = new JButton();
        M = new JButton();
        N = new JButton();
        O = new JButton();
        P = new JButton();
        Q = new JButton();
        R = new JButton();
        S = new JButton();
        T = new JButton();
        U = new JButton();
        V = new JButton();
        W = new JButton();
        X = new JButton();
        Y = new JButton();
        Z = new JButton();
        InstructionsLabel = new JLabel();
        CreditLabel = new JLabel();
        WinPanel = new JPanel();
        WinLabel = new JLabel();
        WinTextLabel = new JLabel();
        LoosePanel = new JPanel();
        LooseLabel = new JLabel();
        LooseTextLabel = new JLabel();
        ErrorLabel = new JLabel();
        ScoreLabel = new JLabel();
        ScoreTextLabel = new JLabel();
        WorkingGame = new GameClass();

        Frame.setLayout(null);
        Frame.setTitle("HANGMAN");
        Frame.setSize(840, 590);
        Frame.setForeground(Color.DARK_GRAY);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setVisible(true);
        NewGameButton.setBounds(720, 40, 110, 40);
        NewGameButton.setIcon(new javax.swing.ImageIcon("src\\hangman\\newGameButtonImage.png"));
        NewGameButton.setVisible(true);
        InstructionsButton.setBounds(720, 120, 110, 40);
        InstructionsButton.setIcon(new javax.swing.ImageIcon("src\\hangman\\instructiosButtonImage.png"));
        InstructionsButton.setVisible(true);
        CreditButton.setBounds(720, 200, 110, 40);
        CreditButton.setIcon(new javax.swing.ImageIcon("src\\hangman\\creditButtonImage.png"));
        CreditButton.setVisible(true);
        ExitButton.setBounds(720, 280, 110, 40);
        ExitButton.setIcon(new javax.swing.ImageIcon("src\\hangman\\exitButtonImage.png"));
        ExitButton.setVisible(true);

        SoundBox.setBackground(new java.awt.Color(0, 0, 0));
        SoundBox.setForeground(new java.awt.Color(255, 255, 255));
        SoundBox.setBounds(5, 535, 100, 20);
        SoundBox.setText("Sound");

        soundLayer.setBounds(0, 535, 30, 20);
        soundLayer.setLayout(null);
        soundLayer.add(SoundBox);
        soundLayer.setVisible(true);

        FrontImageLabel.setBounds(0, 0, 718, 530);
        FrontImageLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\Hangman_front.png"));
        FrontImageLabel.setLayout(null);
        FrontImageLabel.setVisible(true);

        MainPanel.add(FrontImageLabel);
        MainPanel.setVisible(true);

        Frame.add(SoundBox);
        Frame.add(ExitButton);
        Frame.add(NewGameButton);
        Frame.add(InstructionsButton);
        Frame.add(CreditButton);
        Frame.add(MainPanel);

        MainPanel.setBounds(0, 0, 718, 530);
        MainPanel.setLayout(null);
        MainPanel.setVisible(true);

        NewGameButton.setText("NewGame");
        NewGameButton.setLayout(null);
        NewGameButton.setVisible(true);
        InstructionsButton.setText("Instructions");
        InstructionsButton.setLayout(null);
        InstructionsButton.setVisible(true);
        CreditButton.setText("Credit");
        CreditButton.setLayout(null);
        CreditButton.setVisible(true);
        ExitButton.setText("Exit");
        ExitButton.setLayout(null);
        ExitButton.setVisible(true);

        GamePanel.setBounds(0, 0, 718, 530);
        GamePanel.setLayout(null);
        GamePanel.setVisible(true);

        GamePanelColorImageLabel.setBounds(0, 0, 718, 530);
        GamePanelColorImageLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\GamePanelColorImage.png"));

        InstructionsLabel.setBounds(0, 0, 718, 530);
        InstructionsLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\InstructionsLabelImage.png"));

        CreditLabel.setBounds(0, 0, 718, 530);
        CreditLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\CreditLabelImage.png"));

        WinPanel.setBounds(0, 0, 718, 530);
        WinPanel.setLayout(null);
        WinPanel.setVisible(true);
        WinLabel.setBounds(0, 0, 718, 530);
        WinLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\WinPanelImage.JPG"));
        WinPanel.add(WinLabel);
        WinPanel.setVisible(true);

        ErrorLabel.setBounds(403, 215, 315, 315);
        ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\ErrorImage.png"));

        LoosePanel.setBounds(0, 0, 718, 530);
        LoosePanel.setLayout(null);
        LoosePanel.setVisible(true);

        LooseLabel.setBounds(0, 0, 718, 530);
        LooseLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\LoosePanelImage.png"));
        LoosePanel.setVisible(true);

        A.setBounds(1, 0, 50, 30);
        B.setBounds(52, 0, 50, 30);
        C.setBounds(103, 0, 50, 30);
        D.setBounds(154, 0, 50, 30);
        E.setBounds(205, 0, 50, 30);
        F.setBounds(256, 0, 50, 30);
        G.setBounds(307, 0, 50, 30);
        H.setBounds(358, 0, 50, 30);
        I.setBounds(409, 0, 50, 30);
        J.setBounds(460, 0, 50, 30);
        K.setBounds(511, 0, 50, 30);
        L.setBounds(562, 0, 50, 30);
        M.setBounds(613, 0, 50, 30);
        N.setBounds(1, 32, 50, 30);
        O.setBounds(52, 32, 50, 30);
        P.setBounds(103, 32, 50, 30);
        Q.setBounds(154, 32, 50, 30);
        R.setBounds(205, 32, 50, 30);
        S.setBounds(256, 32, 50, 30);
        T.setBounds(307, 32, 50, 30);
        U.setBounds(358, 32, 50, 30);
        V.setBounds(409, 32, 50, 30);
        W.setBounds(460, 32, 50, 30);
        X.setBounds(511, 32, 50, 30);
        Y.setBounds(562, 32, 50, 30);
        Z.setBounds(613, 32, 50, 30);

        A.setText("A");
        B.setText("B");
        C.setText("C");
        D.setText("D");
        E.setText("E");
        F.setText("F");
        G.setText("G");
        H.setText("H");
        I.setText("I");
        J.setText("J");
        K.setText("K");
        L.setText("L");
        M.setText("M");
        N.setText("N");
        O.setText("O");
        P.setText("p");
        Q.setText("Q");
        R.setText("R");
        S.setText("S");
        T.setText("T");
        U.setText("U");
        V.setText("V");
        W.setText("W");
        X.setText("X");
        Y.setText("Y");
        Z.setText("Z");

        GamePanel.setVisible(true);
        SoundBox.setBackground(new java.awt.Color(0, 0, 0));
        SoundBox.setForeground(new java.awt.Color(255, 255, 255));
        SoundBox.setText("Sound");
        /**
         * this methods handles calling the methods of the buttons action
         */
        SoundBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoundBoxActionPerformed(evt);
            }
        });

        NewGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameButtonActionPerformed(evt);
            }

        });

        InstructionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionsActionPerformed(evt);
            }

        });
        CreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditActionPerformed(evt);
            }

        });

        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }

        });
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }

        });
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }

        });
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }

        });
        E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EActionPerformed(evt);
            }

        });
        F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FActionPerformed(evt);
            }

        });
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
k2
        });
        H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HActionPerformed(evt);
            }

        });
        I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IActionPerformed(evt);
            }

        });
        J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JActionPerformed(evt);
            }

        });
        K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KActionPerformed(evt);
            }

        });
        L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LActionPerformed(evt);
            }

        });
        M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MActionPerformed(evt);
            }

        });
        N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NActionPerformed(evt);
            }

        });
        O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OActionPerformed(evt);
            }

        });
        P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PActionPerformed(evt);
            }

        });
        Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QActionPerformed(evt);
            }

        });
        R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActionPerformed(evt);
            }

        });
        S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SActionPerformed(evt);
            }

        });
        T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TActionPerformed(evt);
            }

        });
        U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UActionPerformed(evt);
            }

        });
        V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VActionPerformed(evt);
            }

        });
        W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WActionPerformed(evt);
            }

        });
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }

        });
        Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YActionPerformed(evt);
            }

        });
        Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZActionPerformed(evt);
            }

        });

    }

    /**
     * this methods handles the performances of the buttons soundVarOn and
     * soundVarOff handle the sound
     */

    private void SoundBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoundBoxActionPerformed
        if (soundVarOff) {
            soundVarOff = false;
            soundVarOn = true;
        } else {
            soundVarOff = true;
            soundVarOn = false;
        }
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void NewGameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        ScoreTextLabel.setFont(new Font("Verdana", 1, 30));
        ScoreTextLabel.setForeground(Color.BLUE);
        ScoreTextLabel.setBounds(70, 300, 718, 80);
        ScoreTextLabel.setText("Current Score : " + 8);
        GamePanelColorImageLabel.add(ScoreTextLabel);

        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();

        GamePanel.removeAll();
        GamePanel.repaint();
        GamePanel.revalidate();

        WorkingGame.reset();

        GamePanelColorImageLabel.removeAll();
        GamePanelColorImageLabel.repaint();
        GamePanelColorImageLabel.revalidate();
        GamePanelColorImageLabel.add(WorkingGame);
        GamePanelColorImageLabel.add(ScoreTextLabel);

        GamePanelColorImageLabel.repaint();
        GamePanelColorImageLabel.revalidate();

        GamePanel.add(GamePanelColorImageLabel);

        GamePanelColorImageLabel.add(A);
        GamePanelColorImageLabel.add(B);
        GamePanelColorImageLabel.add(C);
        GamePanelColorImageLabel.add(D);
        GamePanelColorImageLabel.add(E);
        GamePanelColorImageLabel.add(F);
        GamePanelColorImageLabel.add(G);
        GamePanelColorImageLabel.add(H);
        GamePanelColorImageLabel.add(I);
        GamePanelColorImageLabel.add(J);
        GamePanelColorImageLabel.add(K);
        GamePanelColorImageLabel.add(L);
        GamePanelColorImageLabel.add(M);
        GamePanelColorImageLabel.add(N);
        GamePanelColorImageLabel.add(O);
        GamePanelColorImageLabel.add(P);
        GamePanelColorImageLabel.add(Q);
        GamePanelColorImageLabel.add(R);
        GamePanelColorImageLabel.add(S);
        GamePanelColorImageLabel.add(T);
        GamePanelColorImageLabel.add(U);
        GamePanelColorImageLabel.add(V);
        GamePanelColorImageLabel.add(W);
        GamePanelColorImageLabel.add(X);
        GamePanelColorImageLabel.add(Y);
        GamePanelColorImageLabel.add(Z);
        ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\ErrorImage.png"));
        GamePanelColorImageLabel.add(ErrorLabel);
        GamePanelColorImageLabel.repaint();
        GamePanelColorImageLabel.revalidate();

        GamePanel.repaint();
        GamePanel.revalidate();

        MainPanel.add(GamePanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }

    private void InstructionsActionPerformed(java.awt.event.ActionEvent evt) {

        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();

        MainPanel.add(InstructionsLabel);

        MainPanel.repaint();
        MainPanel.revalidate();
    }

    private void CreditActionPerformed(java.awt.event.ActionEvent evt) {

        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();

        MainPanel.add(CreditLabel);

        MainPanel.repaint();
        MainPanel.revalidate();
    }

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.exit(0b0);
    }

    private void AActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 65;
        WorkingGame.check((char) a, "A");

    }

    private void BActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 66;
        WorkingGame.check((char) a, "B");
    }

    private void CActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 67;
        WorkingGame.check((char) a, "C");
    }

    private void DActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 68;
        WorkingGame.check((char) a, "D");
    }

    private void EActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 69;
        WorkingGame.check((char) a, "E");
    }

    private void FActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 70;
        WorkingGame.check((char) a, "F");
    }

    private void GActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 71;
        WorkingGame.check((char) a, "G");
    }

    private void HActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 72;
        WorkingGame.check((char) a, "H");
    }

    private void IActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 73;
        WorkingGame.check((char) a, "I");
    }

    private void JActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 74;
        WorkingGame.check((char) a, "J");
    }

    private void KActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 75;
        WorkingGame.check((char) a, "K");
    }

    private void LActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 76;
        WorkingGame.check((char) a, "L");
    }

    private void MActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 77;
        WorkingGame.check((char) a, "M");
    }

    private void NActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 78;
        WorkingGame.check((char) a, "N");
    }

    private void OActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 79;
        WorkingGame.check((char) a, "O");
    }

    private void PActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 80;
        WorkingGame.check((char) a, "P");
    }

    private void QActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 81;
        WorkingGame.check((char) a, "Q");
    }

    private void RActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 82;
        WorkingGame.check((char) a, "R");
    }

    private void SActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 83;
        WorkingGame.check((char) a, "S");
    }

    private void TActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 84;
        WorkingGame.check((char) a, "T");

    }

    private void UActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 85;
        WorkingGame.check((char) a, "U");
    }

    private void VActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 86;
        WorkingGame.check((char) a, "V");
    }

    private void WActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 87;
        WorkingGame.check((char) a, "W");
    }

    private void XActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 88;
        WorkingGame.check((char) a, "X");
    }

    private void YActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 89;
        WorkingGame.check((char) a, "Y");
    }

    private void ZActionPerformed(java.awt.event.ActionEvent evt) {
        if (soundVarOn) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\hangman\\tick.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        int a = 90;
        WorkingGame.check((char) a, "Z");
    }

    /**
     * main method with a object declaration
     */

    public static void main(String args[]) {

        Hangman object = new Hangman();

    }
    /**
     * all private components declaration
     */
    private javax.swing.JFrame Frame;
    private javax.swing.JCheckBox SoundBox;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel FrontImageLabel;
    private javax.swing.JPanel GamePanel;
    private javax.swing.JLabel GamePanelColorImageLabel;
    private javax.swing.JPanel WinPanel;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JPanel LoosePanel;
    private javax.swing.JLabel WinLabel;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JLabel WinTextLabel;
    private javax.swing.JLabel LooseLabel;
    private javax.swing.JLabel LooseTextLabel;
    private javax.swing.JLabel ScoreTextLabel;
    private javax.swing.JButton NewGameButton;
    private javax.swing.JButton InstructionsButton;
    private javax.swing.JLabel InstructionsLabel;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton CreditButton;
    private javax.swing.JButton ScoreButton;
    private javax.swing.JLabel CreditLabel;
    private javax.swing.JButton A;
    private javax.swing.JButton B;
    private javax.swing.JButton C;
    private javax.swing.JButton D;
    private javax.swing.JButton E;
    private javax.swing.JButton F;
    private javax.swing.JButton G;
    private javax.swing.JButton H;
    private javax.swing.JButton I;
    private javax.swing.JButton J;
    private javax.swing.JButton K;
    private javax.swing.JButton L;
    private javax.swing.JButton M;
    private javax.swing.JButton N;
    private javax.swing.JButton O;
    private javax.swing.JButton P;
    private javax.swing.JButton Q;
    private javax.swing.JButton R;
    private javax.swing.JButton S;
    private javax.swing.JButton T;
    private javax.swing.JButton U;
    private javax.swing.JButton V;
    private javax.swing.JButton W;
    private javax.swing.JButton X;
    private javax.swing.JButton Y;
    private javax.swing.JButton Z;
    private GameClass WorkingGame;
    private javax.swing.JPanel soundLayer;
    private boolean soundVarOn;
    private boolean soundVarOff;

    /**
     * this inner class creates a panel for the main part of the game
     */
    public class GameClass extends JPanel {

        Hangman hangObj;

        /**
         * private components declaration logical part of the game
         */
        private String wordNew;
        private String title;
        private List<JTextField> fields;
        private JPanel pnlFields;
        private JLabel pnlFieldsLabel;
        private JPanel testing;
        private JLabel hintLabel1;
        private int moves, occurences, moveCount;
        private JButton cBtn = new JButton("Moves Left: ");
        String words;
        String hintText;
        int tag[] = new int[100];
        int inputTag[] = new int[100];
        int score;
        int flag;
        int rightCounter = 0;
        int errorCounter = 0;
        String inputString;

        /**
         * this constructor method initializes some components for the GamePanel
         * during playing the new game
         */
        public GameClass() {

            setBackground(Color.PINK);
            setLayout(null);
            setBounds(0, 65, 718, 150);
            pnlFields = new JPanel();
            pnlFieldsLabel = new JLabel();
            pnlFieldsLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\pnlFieldsLabelImage.png"));
            pnlFieldsLabel.setBounds(0, 65, 718, 150);
            hintLabel1 = new JLabel();
            pnlFields.setBounds(0, 65, 718, 150);
            pnlFields.setBackground(Color.PINK);
            add(pnlFields);
            reset();

        }

        /**
         * this reset() method is called each time after NewGameButton is
         * clicked the game is reset after the method is being called
         */
        public void reset() {

            WordFile parsedWord = new WordFile();

            pnlFields.removeAll();
            wordNew = parsedWord.word;
            title = parsedWord.Title;
            rightCounter = 0;
            errorCounter = 0;
            flag = 0;

            for (int j = 0; j < wordNew.length(); j++) {
                tag[j] = 0;
            }

            fields = new ArrayList<>(wordNew.length());
            occurences = wordNew.length();
            moves = occurences + 7;
            moveCount = 0;

            /**
             * creating textFields according to the number of the word-length
             */
            for (int index = 0; index < wordNew.length(); index++) {
                JTextField field = new JTextField(3);
                field.setEditable(false);
                field.setHorizontalAlignment(JTextField.CENTER);
                field.setFont(new Font("Tahoma", 1, 15));
                fields.add(field);
                pnlFields.add(field);
            }
            /**
             * random number generating fro hint showing
             */
            Random rn = new Random();
            int ranInt = rn.nextInt(2);
            if (ranInt == 0) {
                hintLabel1.setText("Hint:  " + title + ",starts with " + wordNew.charAt(0));
            } else {
                hintLabel1.setText("Hint: " + title + ",ends with " + wordNew.charAt(occurences - 1));
            }

            hintLabel1.setVerticalAlignment(JLabel.NORTH);
            pnlFields.add(hintLabel1);

            cBtn.removeAll();
            cBtn.repaint();
            cBtn.revalidate();
            cBtn.setBounds(170, 70, 150, 30);
            cBtn.setBackground(Color.CYAN);
            cBtn.setText("Moves Left: " + moves);
            pnlFields.add(cBtn);

        }

        /**
         * method check() checks the input letter with each position of the word
         * and if matches, the shows it to the textField
         *
         * @param input is passed from the letter action methods
         * @param inputString the string which is meant by input parameter
         */
        public void check(char input, String inputString) {

            moves--;
            moveCount++;
            cBtn.setText("Moves left: " + moves);
            
            for (int j = 0; j < wordNew.length(); j++) {
                inputTag[j] = 0;
            }
            flag = 0;
            for (int j = 0; j < wordNew.length(); j++) {

                if (input == wordNew.charAt(j)) {

                    if (tag[j] == 0) {
                        ++rightCounter;
                        occurences--;
                        tag[j] = 1;
                    } else {
                        ++errorCounter;
                    }
                    flag = 1;
                    inputTag[j] = 1;
                }

            }
            if (flag == 0) {
                ++errorCounter;
            }

            for (int I = 0; I < wordNew.length(); I++) {
                if (tag[I] == 1 && inputTag[I] == 1) {
                    fields.get(I).setText(inputString);
                }

            }

            if (errorCounter == 1) {
                ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\error0.png"));
                GamePanelColorImageLabel.add(ErrorLabel);
                GamePanelColorImageLabel.repaint();
                GamePanelColorImageLabel.revalidate();
            }
            if (errorCounter == 2) {
                ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\error1.png"));
                GamePanelColorImageLabel.repaint();
                GamePanelColorImageLabel.revalidate();
            }
            if (errorCounter == 3) {
                ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\error2.png"));
                GamePanelColorImageLabel.repaint();
                GamePanelColorImageLabel.revalidate();
            }
            if (errorCounter == 4) {
                ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\error3.png"));
                GamePanelColorImageLabel.repaint();
                GamePanelColorImageLabel.revalidate();
            }
            if (errorCounter == 5) {
                ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\error4.png"));
                GamePanelColorImageLabel.repaint();
                GamePanelColorImageLabel.revalidate();
            }
            if (errorCounter == 6) {
                ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\error5.png"));
                GamePanelColorImageLabel.repaint();
                GamePanelColorImageLabel.revalidate();
            }
            if (errorCounter == 7) {
                ErrorLabel.setIcon(new javax.swing.ImageIcon("src\\hangman\\error6.png"));
                GamePanelColorImageLabel.repaint();
                GamePanelColorImageLabel.revalidate();
            }
            if (errorCounter > 7) {
                try {
                    /**
                     * the file score.text saves the number of right letters and
                     * wrong letters for each time game is played
                     */
                    PrintWriter pw = new PrintWriter("score.text");
                    pw.printf("%d %d", rightCounter, errorCounter);
                    pw.close();
                } catch (FileNotFoundException E) {
                    E.printStackTrace();
                }

                GamePanel.removeAll();
                GamePanel.repaint();
                GamePanel.revalidate();
                LooseTextLabel.setText("        SORRY!!  The word is " + wordNew);

                LooseTextLabel.setFont(new Font("Verdana", 1, 20));
                LooseTextLabel.setForeground(Color.BLACK);
                LooseTextLabel.setBounds(110, 5, 718, 80);

                LoosePanel.add(LooseTextLabel);
                LoosePanel.add(LooseLabel);

                LoosePanel.repaint();
                LoosePanel.revalidate();

                GamePanel.add(LoosePanel);
                GamePanel.repaint();
                GamePanel.revalidate();

            } else if ((rightCounter == wordNew.length() && moves == 0) || (rightCounter == wordNew.length() && moves > 0)) {

                try {
                    /**
                     * the file score.text saves the number of right letters and
                     * wrong letters for each time game is played
                     */
                    PrintWriter pw = new PrintWriter("score.text");
                    pw.printf("%d %d", rightCounter, errorCounter);
                    pw.close();
                } catch (FileNotFoundException E) {
                    E.printStackTrace();
                }

                score = 8 - errorCounter;

                GamePanel.removeAll();
                GamePanel.repaint();
                GamePanel.revalidate();

                WinTextLabel.setText(" YES!! You won the game :D !! " + "Your  score  is : " + score);

                WinTextLabel.setFont(new Font("Verdana", 1, 20));
                WinTextLabel.setForeground(Color.BLACK);
                WinTextLabel.setBounds(100, 5, 718, 80);

                WinPanel.add(WinTextLabel);
                WinPanel.add(WinLabel);
                WinPanel.repaint();
                WinPanel.revalidate();

                GamePanel.add(WinPanel);
                GamePanel.repaint();
                GamePanel.revalidate();

            }
            if ((rightCounter != 0) || (errorCounter != 0)) {

                ScoreTextLabel.setFont(new Font("Verdana", 1, 30));
                ScoreTextLabel.setForeground(Color.BLUE);
                ScoreTextLabel.setBounds(70, 300, 718, 80);

                ScoreTextLabel.setText("Current Score : " + (8 - errorCounter));
                GamePanelColorImageLabel.add(ScoreTextLabel);

            }

        }
    }
}
