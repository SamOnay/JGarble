/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.jgarble;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Main interface of Garble and runs the entire game
 * @author 1ZHAOJIN2
 */
public class JGarble_Interface extends javax.swing.JFrame{

    Garble garbleGame;
    /**
     * Creates new form JGarble_Interface
     * @throws java.lang.Exception
     */
    public JGarble_Interface() throws Exception{
        this.garbleGame = new Garble(WordReader.randomWord());

        // initializes lists
        initComponents();
        initList();
        initLetterList();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(Garble.hasGameEnded) return;
                
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if(letterCount > 0) {
                    enteredLetters = enteredLetters.substring(0, enteredLetters.length()-1);
                    letterCount--;
                    myLabels[rowCount*6 + letterCount].setText("");
                    }
                } else if (Character.isLetter(e.getKeyChar())) {
                    String letter = String.valueOf(e.getKeyChar()).toUpperCase();
                    enteredLetters += letter;
                    enteredLetter = letter;
                    displayLetter();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // check if there are indeed 6 letters in the current row. If there are not then skip
                    if(letterCount >= 6) {
                        enteredLetters = enteredLetters.substring(0,6);

                        //check if the entered letters are a valid word, if it is not a valid word, and it is not a user overwritten word, then skip the entire code
                        try {
                            if(!WordReader.validWord(enteredLetters.toLowerCase()) && !userOverride){
                                enteredLetters = "";
                                letterCount = 0;
                                for(int i = 0; i < 6; i++) {
                                    myLabels[rowCount*6+i].setText("");
                                }

                                garbleInformationBar.setForeground(new Color(135, 37, 61));
                                garbleInformationBar.setText("Not in Word List!");
                                return;
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        //grabs color from Garble class to display on the
                        garbleGame.takeGuess(enteredLetters.toLowerCase());
                        ArrayList<Color> colors = garbleGame.getColors();

                        // apply colors to both the display area and the keyboard
                        for(int i = 0; i < 6; i++) {
                            int currBox = (rowCount)*6 + i;
                            myLabels[currBox].setBackground(colors.get(i));
                            int currLetterIndex = allLetters.indexOf(myLabels[currBox].getText());
                            Color customGreen = new Color(83,141,78);
                            Color customYellow = new Color(94, 94, 98);
                            if(myLetters[currLetterIndex].getBackground().getRGB() != customGreen.getRGB()) {
                                if(myLetters[currLetterIndex].getBackground().getRGB() != customYellow.getRGB()) {
                                    myLetters[currLetterIndex].setBackground(colors.get(i));
                                    myLetters[currLetterIndex].setOpaque(true);
                                    myLetters[currLetterIndex].setBorder(javax.swing.BorderFactory.createEmptyBorder());
                                }
                            }
                        }

                        //checks if the game has ended and the player has won.
                        if(Garble.hasGameEnded) {
                            garbleInformationBar.setForeground(new Color(83,141,78));
                            garbleInformationBar.setText("You won! Please close the app and reopen if you want to try again.");
                            try {
                                StatsUpdater.win();
                            } catch (Exception ex) {
                                Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        // the following codes are preparing for the next user entry. It resets the pointer and move it to the next row, and clearing previously used variables

                        // switch to the next row
                        rowCount++;

                        // reset the entered letters string
                        enteredLetters = "";

                        // reset the letter count to 0
                        letterCount = 0;
                    }

                    //checks if the player has lost the game
                    if(rowCount == 6 && !Garble.hasGameEnded) {
                        garbleInformationBar.setForeground(new Color(181, 159, 59));
                        garbleInformationBar.setText("It looks like you lost :( the word is " + Garble.staticWord);


                        try {
                            StatsUpdater.lose();
                        } catch (Exception ex) {
                            Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // not used
            }
        });
        setFocusable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    /**
     * initializes all the components, including color, size, position and hierarchy
     */
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        sideButtonSettings = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sideBarIndicator3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sideButtonStats = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        sideBarIndicator2 = new javax.swing.JPanel();
        sideButtonGame = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        sideBarIndicator1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        gamePanel = new javax.swing.JPanel();
        key_e = new javax.swing.JLabel();
        button_enter = new javax.swing.JLabel();
        key_r = new javax.swing.JLabel();
        button_backspace = new javax.swing.JLabel();
        key_t = new javax.swing.JLabel();
        key_y = new javax.swing.JLabel();
        key_i = new javax.swing.JLabel();
        key_o = new javax.swing.JLabel();
        key_p = new javax.swing.JLabel();
        key_d = new javax.swing.JLabel();
        key_f = new javax.swing.JLabel();
        key_g = new javax.swing.JLabel();
        key_h = new javax.swing.JLabel();
        key_j = new javax.swing.JLabel();
        key_k = new javax.swing.JLabel();
        key_a = new javax.swing.JLabel();
        key_l = new javax.swing.JLabel();
        key_x = new javax.swing.JLabel();
        key_c = new javax.swing.JLabel();
        key_z = new javax.swing.JLabel();
        key_v = new javax.swing.JLabel();
        key_q = new javax.swing.JLabel();
        key_w = new javax.swing.JLabel();
        key_n = new javax.swing.JLabel();
        key_b = new javax.swing.JLabel();
        key_m = new javax.swing.JLabel();
        key_s = new javax.swing.JLabel();
        key_u = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        box_0_0 = new javax.swing.JLabel();
        box_0_1 = new javax.swing.JLabel();
        box_0_2 = new javax.swing.JLabel();
        box_0_3 = new javax.swing.JLabel();
        box_0_4 = new javax.swing.JLabel();
        box_0_5 = new javax.swing.JLabel();
        box_1_0 = new javax.swing.JLabel();
        box_1_1 = new javax.swing.JLabel();
        box_1_2 = new javax.swing.JLabel();
        box_1_3 = new javax.swing.JLabel();
        box_1_4 = new javax.swing.JLabel();
        box_1_5 = new javax.swing.JLabel();
        box_2_0 = new javax.swing.JLabel();
        box_2_1 = new javax.swing.JLabel();
        box_2_2 = new javax.swing.JLabel();
        box_2_5 = new javax.swing.JLabel();
        box_2_3 = new javax.swing.JLabel();
        box_2_4 = new javax.swing.JLabel();
        box_3_0 = new javax.swing.JLabel();
        box_3_1 = new javax.swing.JLabel();
        box_3_2 = new javax.swing.JLabel();
        box_4_0 = new javax.swing.JLabel();
        box_4_1 = new javax.swing.JLabel();
        box_4_2 = new javax.swing.JLabel();
        box_5_0 = new javax.swing.JLabel();
        box_5_1 = new javax.swing.JLabel();
        box_5_2 = new javax.swing.JLabel();
        box_3_3 = new javax.swing.JLabel();
        box_3_4 = new javax.swing.JLabel();
        box_3_5 = new javax.swing.JLabel();
        box_4_3 = new javax.swing.JLabel();
        box_4_4 = new javax.swing.JLabel();
        box_4_5 = new javax.swing.JLabel();
        box_5_3 = new javax.swing.JLabel();
        box_5_4 = new javax.swing.JLabel();
        box_5_5 = new javax.swing.JLabel();
        garbleInformationBar = new javax.swing.JLabel();
        statsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        totalGamesPlayedLabel = new javax.swing.JLabel();
        totalGameWinsLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        winPercentageLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        currWinStreakLabel = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        longestWinStreakLabel = new javax.swing.JLabel();
        settingsPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        newWordTextfield = new javax.swing.JTextField();
        setWordButton = new javax.swing.JButton();
        settingsPanelIndicatorLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 780));

        sidebar.setBackground(new java.awt.Color(68, 72, 80));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideButtonSettings.setBackground(new java.awt.Color(68, 72, 80));
        sideButtonSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sideButtonSettingsMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Settings");

        sideBarIndicator3.setBackground(new java.awt.Color(255, 255, 255));
        sideBarIndicator3.setOpaque(false);
        sideBarIndicator3.setPreferredSize(new java.awt.Dimension(5, 44));

        javax.swing.GroupLayout sideBarIndicator3Layout = new javax.swing.GroupLayout(sideBarIndicator3);
        sideBarIndicator3.setLayout(sideBarIndicator3Layout);
        sideBarIndicator3Layout.setHorizontalGroup(
            sideBarIndicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        sideBarIndicator3Layout.setVerticalGroup(
            sideBarIndicator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sideButtonSettingsLayout = new javax.swing.GroupLayout(sideButtonSettings);
        sideButtonSettings.setLayout(sideButtonSettingsLayout);
        sideButtonSettingsLayout.setHorizontalGroup(
            sideButtonSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideButtonSettingsLayout.createSequentialGroup()
                .addComponent(sideBarIndicator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        sideButtonSettingsLayout.setVerticalGroup(
            sideButtonSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideButtonSettingsLayout.createSequentialGroup()
                .addGroup(sideButtonSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideBarIndicator3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGroup(sideButtonSettingsLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
        );

        sidebar.add(sideButtonSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 198, 40));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GARBLE");
        jLabel1.setPreferredSize(new java.awt.Dimension(64, 64));
        sidebar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 186, -1));

        sideButtonStats.setBackground(new java.awt.Color(68, 72, 80));
        sideButtonStats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sideButtonStatsMousePressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Stats");

        sideBarIndicator2.setBackground(new java.awt.Color(255, 255, 255));
        sideBarIndicator2.setOpaque(false);
        sideBarIndicator2.setPreferredSize(new java.awt.Dimension(5, 44));

        javax.swing.GroupLayout sideBarIndicator2Layout = new javax.swing.GroupLayout(sideBarIndicator2);
        sideBarIndicator2.setLayout(sideBarIndicator2Layout);
        sideBarIndicator2Layout.setHorizontalGroup(
            sideBarIndicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        sideBarIndicator2Layout.setVerticalGroup(
            sideBarIndicator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sideButtonStatsLayout = new javax.swing.GroupLayout(sideButtonStats);
        sideButtonStats.setLayout(sideButtonStatsLayout);
        sideButtonStatsLayout.setHorizontalGroup(
            sideButtonStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideButtonStatsLayout.createSequentialGroup()
                .addComponent(sideBarIndicator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        sideButtonStatsLayout.setVerticalGroup(
            sideButtonStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideButtonStatsLayout.createSequentialGroup()
                .addGroup(sideButtonStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideBarIndicator2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGroup(sideButtonStatsLayout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
        );

        sidebar.add(sideButtonStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 198, 40));

        sideButtonGame.setBackground(new java.awt.Color(93, 99, 108));
        sideButtonGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sideButtonGameMousePressed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Game");

        sideBarIndicator1.setBackground(new java.awt.Color(255, 255, 255));
        sideBarIndicator1.setPreferredSize(new java.awt.Dimension(5, 44));

        javax.swing.GroupLayout sideBarIndicator1Layout = new javax.swing.GroupLayout(sideBarIndicator1);
        sideBarIndicator1.setLayout(sideBarIndicator1Layout);
        sideBarIndicator1Layout.setHorizontalGroup(
            sideBarIndicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        sideBarIndicator1Layout.setVerticalGroup(
            sideBarIndicator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sideButtonGameLayout = new javax.swing.GroupLayout(sideButtonGame);
        sideButtonGame.setLayout(sideButtonGameLayout);
        sideButtonGameLayout.setHorizontalGroup(
            sideButtonGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideButtonGameLayout.createSequentialGroup()
                .addComponent(sideBarIndicator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        sideButtonGameLayout.setVerticalGroup(
            sideButtonGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideButtonGameLayout.createSequentialGroup()
                .addGroup(sideButtonGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideBarIndicator1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGroup(sideButtonGameLayout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(62, 62, 62))
        );

        sidebar.add(sideButtonGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 198, 40));

        mainPanel.setLayout(new java.awt.CardLayout());

        gamePanel.setBackground(new java.awt.Color(30, 32, 35));
        gamePanel.setMinimumSize(new java.awt.Dimension(810, 810));
        gamePanel.setPreferredSize(new java.awt.Dimension(780, 810));

        key_e.setBackground(new java.awt.Color(40, 45, 51));
        key_e.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_e.setForeground(new java.awt.Color(255, 255, 255));
        key_e.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_e.setText("E");
        key_e.setOpaque(true);
        key_e.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_eMousePressed(evt);
            }
        });

        button_enter.setBackground(new java.awt.Color(40, 45, 51));
        button_enter.setFont(new java.awt.Font("Source Code Pro", 1, 24)); // NOI18N
        button_enter.setForeground(new java.awt.Color(255, 255, 255));
        button_enter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_enter.setText("Enter");
        button_enter.setOpaque(true);
        button_enter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button_enterMousePressed(evt);
            }
        });

        key_r.setBackground(new java.awt.Color(40, 45, 51));
        key_r.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_r.setForeground(new java.awt.Color(255, 255, 255));
        key_r.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_r.setText("R");
        key_r.setOpaque(true);
        key_r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_rMousePressed(evt);
            }
        });

        button_backspace.setBackground(new java.awt.Color(40, 45, 51));
        button_backspace.setFont(new java.awt.Font("Source Code Pro", 1, 24)); // NOI18N
        button_backspace.setForeground(new java.awt.Color(255, 255, 255));
        button_backspace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_backspace.setText("Del");
        button_backspace.setOpaque(true);
        button_backspace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button_backspaceMousePressed(evt);
            }
        });

        key_t.setBackground(new java.awt.Color(40, 45, 51));
        key_t.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_t.setForeground(new java.awt.Color(255, 255, 255));
        key_t.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_t.setText("T");
        key_t.setOpaque(true);
        key_t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_tMousePressed(evt);
            }
        });

        key_y.setBackground(new java.awt.Color(40, 45, 51));
        key_y.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_y.setForeground(new java.awt.Color(255, 255, 255));
        key_y.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_y.setText("Y");
        key_y.setOpaque(true);
        key_y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_yMousePressed(evt);
            }
        });

        key_i.setBackground(new java.awt.Color(40, 45, 51));
        key_i.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_i.setForeground(new java.awt.Color(255, 255, 255));
        key_i.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_i.setText("I");
        key_i.setOpaque(true);
        key_i.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_iMousePressed(evt);
            }
        });

        key_o.setBackground(new java.awt.Color(40, 45, 51));
        key_o.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_o.setForeground(new java.awt.Color(255, 255, 255));
        key_o.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_o.setText("O");
        key_o.setOpaque(true);
        key_o.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_oMousePressed(evt);
            }
        });

        key_p.setBackground(new java.awt.Color(40, 45, 51));
        key_p.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_p.setForeground(new java.awt.Color(255, 255, 255));
        key_p.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_p.setText("P");
        key_p.setOpaque(true);
        key_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_pMousePressed(evt);
            }
        });

        key_d.setBackground(new java.awt.Color(40, 45, 51));
        key_d.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_d.setForeground(new java.awt.Color(255, 255, 255));
        key_d.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_d.setText("D");
        key_d.setOpaque(true);
        key_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_dMousePressed(evt);
            }
        });

        key_f.setBackground(new java.awt.Color(40, 45, 51));
        key_f.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_f.setForeground(new java.awt.Color(255, 255, 255));
        key_f.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_f.setText("F");
        key_f.setOpaque(true);
        key_f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_fMousePressed(evt);
            }
        });

        key_g.setBackground(new java.awt.Color(40, 45, 51));
        key_g.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_g.setForeground(new java.awt.Color(255, 255, 255));
        key_g.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_g.setText("G");
        key_g.setOpaque(true);
        key_g.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_gMousePressed(evt);
            }
        });

        key_h.setBackground(new java.awt.Color(40, 45, 51));
        key_h.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_h.setForeground(new java.awt.Color(255, 255, 255));
        key_h.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_h.setText("H");
        key_h.setOpaque(true);
        key_h.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_hMousePressed(evt);
            }
        });

        key_j.setBackground(new java.awt.Color(40, 45, 51));
        key_j.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_j.setForeground(new java.awt.Color(255, 255, 255));
        key_j.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_j.setText("J");
        key_j.setOpaque(true);
        key_j.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_jMousePressed(evt);
            }
        });

        key_k.setBackground(new java.awt.Color(40, 45, 51));
        key_k.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_k.setForeground(new java.awt.Color(255, 255, 255));
        key_k.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_k.setText("K");
        key_k.setOpaque(true);
        key_k.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_kMousePressed(evt);
            }
        });

        key_a.setBackground(new java.awt.Color(40, 45, 51));
        key_a.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_a.setForeground(new java.awt.Color(255, 255, 255));
        key_a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_a.setText("A");
        key_a.setOpaque(true);
        key_a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_aMousePressed(evt);
            }
        });

        key_l.setBackground(new java.awt.Color(40, 45, 51));
        key_l.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_l.setForeground(new java.awt.Color(255, 255, 255));
        key_l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_l.setText("L");
        key_l.setOpaque(true);
        key_l.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_lMousePressed(evt);
            }
        });

        key_x.setBackground(new java.awt.Color(40, 45, 51));
        key_x.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_x.setForeground(new java.awt.Color(255, 255, 255));
        key_x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_x.setText("X");
        key_x.setOpaque(true);
        key_x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_xMousePressed(evt);
            }
        });

        key_c.setBackground(new java.awt.Color(40, 45, 51));
        key_c.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_c.setForeground(new java.awt.Color(255, 255, 255));
        key_c.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_c.setText("C");
        key_c.setOpaque(true);
        key_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_cMousePressed(evt);
            }
        });

        key_z.setBackground(new java.awt.Color(40, 45, 51));
        key_z.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_z.setForeground(new java.awt.Color(255, 255, 255));
        key_z.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_z.setText("Z");
        key_z.setOpaque(true);
        key_z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_zMousePressed(evt);
            }
        });

        key_v.setBackground(new java.awt.Color(40, 45, 51));
        key_v.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_v.setForeground(new java.awt.Color(255, 255, 255));
        key_v.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_v.setText("V");
        key_v.setOpaque(true);
        key_v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_vMousePressed(evt);
            }
        });

        key_q.setBackground(new java.awt.Color(40, 45, 51));
        key_q.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_q.setForeground(new java.awt.Color(255, 255, 255));
        key_q.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_q.setText("Q");
        key_q.setOpaque(true);
        key_q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_qMousePressed(evt);
            }
        });

        key_w.setBackground(new java.awt.Color(40, 45, 51));
        key_w.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_w.setForeground(new java.awt.Color(255, 255, 255));
        key_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_w.setText("W");
        key_w.setOpaque(true);
        key_w.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_wMousePressed(evt);
            }
        });

        key_n.setBackground(new java.awt.Color(40, 45, 51));
        key_n.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_n.setForeground(new java.awt.Color(255, 255, 255));
        key_n.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_n.setText("N");
        key_n.setOpaque(true);
        key_n.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_nMousePressed(evt);
            }
        });

        key_b.setBackground(new java.awt.Color(40, 45, 51));
        key_b.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_b.setForeground(new java.awt.Color(255, 255, 255));
        key_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_b.setText("B");
        key_b.setOpaque(true);
        key_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_bMousePressed(evt);
            }
        });

        key_m.setBackground(new java.awt.Color(40, 45, 51));
        key_m.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_m.setForeground(new java.awt.Color(255, 255, 255));
        key_m.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_m.setText("M");
        key_m.setOpaque(true);
        key_m.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_mMousePressed(evt);
            }
        });

        key_s.setBackground(new java.awt.Color(40, 45, 51));
        key_s.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_s.setForeground(new java.awt.Color(255, 255, 255));
        key_s.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_s.setText("S");
        key_s.setOpaque(true);
        key_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_sMousePressed(evt);
            }
        });

        key_u.setBackground(new java.awt.Color(40, 45, 51));
        key_u.setFont(new java.awt.Font("Source Code Pro", 1, 36)); // NOI18N
        key_u.setForeground(new java.awt.Color(255, 255, 255));
        key_u.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        key_u.setText("U");
        key_u.setOpaque(true);
        key_u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                key_uMousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(43, 46, 50));
        jPanel2.setOpaque(false);

        box_0_0.setBackground(new java.awt.Color(40, 45, 51));
        box_0_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_0_0.setForeground(new java.awt.Color(255, 255, 255));
        box_0_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_0_0.setOpaque(true);

        box_0_1.setBackground(new java.awt.Color(40, 45, 51));
        box_0_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_0_1.setForeground(new java.awt.Color(255, 255, 255));
        box_0_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_0_1.setOpaque(true);

        box_0_2.setBackground(new java.awt.Color(40, 45, 51));
        box_0_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_0_2.setForeground(new java.awt.Color(255, 255, 255));
        box_0_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_0_2.setOpaque(true);

        box_0_3.setBackground(new java.awt.Color(40, 45, 51));
        box_0_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_0_3.setForeground(new java.awt.Color(255, 255, 255));
        box_0_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_0_3.setOpaque(true);

        box_0_4.setBackground(new java.awt.Color(40, 45, 51));
        box_0_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_0_4.setForeground(new java.awt.Color(255, 255, 255));
        box_0_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_0_4.setOpaque(true);

        box_0_5.setBackground(new java.awt.Color(40, 45, 51));
        box_0_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_0_5.setForeground(new java.awt.Color(255, 255, 255));
        box_0_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_0_5.setOpaque(true);

        box_1_0.setBackground(new java.awt.Color(40, 45, 51));
        box_1_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_1_0.setForeground(new java.awt.Color(255, 255, 255));
        box_1_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_1_0.setOpaque(true);

        box_1_1.setBackground(new java.awt.Color(40, 45, 51));
        box_1_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_1_1.setForeground(new java.awt.Color(255, 255, 255));
        box_1_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_1_1.setOpaque(true);

        box_1_2.setBackground(new java.awt.Color(40, 45, 51));
        box_1_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_1_2.setForeground(new java.awt.Color(255, 255, 255));
        box_1_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_1_2.setOpaque(true);

        box_1_3.setBackground(new java.awt.Color(40, 45, 51));
        box_1_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_1_3.setForeground(new java.awt.Color(255, 255, 255));
        box_1_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_1_3.setOpaque(true);

        box_1_4.setBackground(new java.awt.Color(40, 45, 51));
        box_1_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_1_4.setForeground(new java.awt.Color(255, 255, 255));
        box_1_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_1_4.setOpaque(true);

        box_1_5.setBackground(new java.awt.Color(40, 45, 51));
        box_1_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_1_5.setForeground(new java.awt.Color(255, 255, 255));
        box_1_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_1_5.setOpaque(true);

        box_2_0.setBackground(new java.awt.Color(40, 45, 51));
        box_2_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_2_0.setForeground(new java.awt.Color(255, 255, 255));
        box_2_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_2_0.setOpaque(true);

        box_2_1.setBackground(new java.awt.Color(40, 45, 51));
        box_2_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_2_1.setForeground(new java.awt.Color(255, 255, 255));
        box_2_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_2_1.setOpaque(true);

        box_2_2.setBackground(new java.awt.Color(40, 45, 51));
        box_2_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_2_2.setForeground(new java.awt.Color(255, 255, 255));
        box_2_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_2_2.setOpaque(true);

        box_2_5.setBackground(new java.awt.Color(40, 45, 51));
        box_2_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_2_5.setForeground(new java.awt.Color(255, 255, 255));
        box_2_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_2_5.setOpaque(true);

        box_2_3.setBackground(new java.awt.Color(40, 45, 51));
        box_2_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_2_3.setForeground(new java.awt.Color(255, 255, 255));
        box_2_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_2_3.setOpaque(true);

        box_2_4.setBackground(new java.awt.Color(40, 45, 51));
        box_2_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_2_4.setForeground(new java.awt.Color(255, 255, 255));
        box_2_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_2_4.setOpaque(true);

        box_3_0.setBackground(new java.awt.Color(40, 45, 51));
        box_3_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_3_0.setForeground(new java.awt.Color(255, 255, 255));
        box_3_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_3_0.setOpaque(true);

        box_3_1.setBackground(new java.awt.Color(40, 45, 51));
        box_3_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_3_1.setForeground(new java.awt.Color(255, 255, 255));
        box_3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_3_1.setOpaque(true);

        box_3_2.setBackground(new java.awt.Color(40, 45, 51));
        box_3_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_3_2.setForeground(new java.awt.Color(255, 255, 255));
        box_3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_3_2.setOpaque(true);

        box_4_0.setBackground(new java.awt.Color(40, 45, 51));
        box_4_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_4_0.setForeground(new java.awt.Color(255, 255, 255));
        box_4_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_4_0.setOpaque(true);

        box_4_1.setBackground(new java.awt.Color(40, 45, 51));
        box_4_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_4_1.setForeground(new java.awt.Color(255, 255, 255));
        box_4_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_4_1.setOpaque(true);

        box_4_2.setBackground(new java.awt.Color(40, 45, 51));
        box_4_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_4_2.setForeground(new java.awt.Color(255, 255, 255));
        box_4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_4_2.setOpaque(true);

        box_5_0.setBackground(new java.awt.Color(40, 45, 51));
        box_5_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_5_0.setForeground(new java.awt.Color(255, 255, 255));
        box_5_0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_5_0.setOpaque(true);

        box_5_1.setBackground(new java.awt.Color(40, 45, 51));
        box_5_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_5_1.setForeground(new java.awt.Color(255, 255, 255));
        box_5_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_5_1.setOpaque(true);

        box_5_2.setBackground(new java.awt.Color(40, 45, 51));
        box_5_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_5_2.setForeground(new java.awt.Color(255, 255, 255));
        box_5_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_5_2.setOpaque(true);

        box_3_3.setBackground(new java.awt.Color(40, 45, 51));
        box_3_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_3_3.setForeground(new java.awt.Color(255, 255, 255));
        box_3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_3_3.setOpaque(true);

        box_3_4.setBackground(new java.awt.Color(40, 45, 51));
        box_3_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_3_4.setForeground(new java.awt.Color(255, 255, 255));
        box_3_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_3_4.setOpaque(true);

        box_3_5.setBackground(new java.awt.Color(40, 45, 51));
        box_3_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_3_5.setForeground(new java.awt.Color(255, 255, 255));
        box_3_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_3_5.setOpaque(true);

        box_4_3.setBackground(new java.awt.Color(40, 45, 51));
        box_4_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_4_3.setForeground(new java.awt.Color(255, 255, 255));
        box_4_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_4_3.setOpaque(true);

        box_4_4.setBackground(new java.awt.Color(40, 45, 51));
        box_4_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_4_4.setForeground(new java.awt.Color(255, 255, 255));
        box_4_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_4_4.setOpaque(true);

        box_4_5.setBackground(new java.awt.Color(40, 45, 51));
        box_4_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_4_5.setForeground(new java.awt.Color(255, 255, 255));
        box_4_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_4_5.setOpaque(true);

        box_5_3.setBackground(new java.awt.Color(40, 45, 51));
        box_5_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_5_3.setForeground(new java.awt.Color(255, 255, 255));
        box_5_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_5_3.setOpaque(true);

        box_5_4.setBackground(new java.awt.Color(40, 45, 51));
        box_5_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_5_4.setForeground(new java.awt.Color(255, 255, 255));
        box_5_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_5_4.setOpaque(true);

        box_5_5.setBackground(new java.awt.Color(40, 45, 51));
        box_5_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        box_5_5.setForeground(new java.awt.Color(255, 255, 255));
        box_5_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        box_5_5.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(box_5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(box_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(box_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(box_1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(box_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(box_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(box_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(box_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(box_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(box_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(box_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(box_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(box_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(box_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(149, 149, 149))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(box_0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(box_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(box_1_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(box_1_0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(box_1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box_2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(box_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(box_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box_5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(box_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(box_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(box_5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        garbleInformationBar.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        garbleInformationBar.setForeground(new java.awt.Color(135, 37, 61));
        garbleInformationBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(key_a, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_s, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_d, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_f, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_g, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_h, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_j, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_k, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_l, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(button_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_z, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_x, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_c, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_v, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_b, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_n, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_m, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(button_backspace, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(key_q, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_w, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_e, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_r, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_t, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_y, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_u, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_i, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_o, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(key_p, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(garbleInformationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(garbleInformationBar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(key_q, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_w, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_e, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_r, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_t, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_y, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_u, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_i, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_o, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_p, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(key_a, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_s, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_d, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_f, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_g, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_h, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_j, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_k, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_l, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_z, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_x, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_c, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_v, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_b, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_n, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(key_m, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        mainPanel.add(gamePanel, "gamePanel");

        statsPanel.setBackground(new java.awt.Color(30, 32, 35));
        statsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        statsPanel.setPreferredSize(new java.awt.Dimension(780, 810));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+17));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Statistics");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Games Played");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Wins");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Win Percentage:");

        totalGamesPlayedLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        totalGamesPlayedLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalGamesPlayedLabel.setText("0");

        totalGameWinsLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        totalGameWinsLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalGameWinsLabel.setText("0");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("%");

        winPercentageLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        winPercentageLabel.setForeground(new java.awt.Color(255, 255, 255));
        winPercentageLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        winPercentageLabel.setText("0");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Current Win Streak");

        currWinStreakLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        currWinStreakLabel.setForeground(new java.awt.Color(255, 255, 255));
        currWinStreakLabel.setText("0");

        resetButton.setText("RESET");
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resetButtonMousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Longest Win Streak");

        longestWinStreakLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 25)); // NOI18N
        longestWinStreakLabel.setForeground(new java.awt.Color(255, 255, 255));
        longestWinStreakLabel.setText("0");

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(resetButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statsPanelLayout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(174, 174, 174)
                        .addComponent(winPercentageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(statsPanelLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(longestWinStreakLabel))
                        .addGroup(statsPanelLayout.createSequentialGroup()
                            .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(currWinStreakLabel)
                                .addComponent(totalGameWinsLabel)
                                .addComponent(totalGamesPlayedLabel)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(183, 183, 183))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalGamesPlayedLabel)
                    .addComponent(jLabel5))
                .addGap(50, 50, 50)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalGameWinsLabel))
                .addGap(50, 50, 50)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(currWinStreakLabel))
                .addGap(50, 50, 50)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(longestWinStreakLabel))
                .addGap(50, 50, 50)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(winPercentageLabel)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(resetButton)
                .addGap(52, 52, 52))
        );

        mainPanel.add(statsPanel, "statsPanel");

        settingsPanel.setBackground(new java.awt.Color(30, 32, 35));
        settingsPanel.setPreferredSize(new java.awt.Dimension(810, 810));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Set the custom 6-letters word for your Garble game (must use before game start)");

        newWordTextfield.setBackground(new java.awt.Color(10, 11, 13));
        newWordTextfield.setForeground(new java.awt.Color(255, 255, 255));

        setWordButton.setText("Set Word");
        setWordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                setWordButtonMousePressed(evt);
            }
        });

        settingsPanelIndicatorLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingsPanelIndicatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                            .addComponent(newWordTextfield)
                            .addGap(18, 18, 18)
                            .addComponent(setWordButton))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settingsPanelIndicatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newWordTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setWordButton))
                .addContainerGap(704, Short.MAX_VALUE))
        );

        mainPanel.add(settingsPanel, "settingsPanel");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /*
     * The following 3 methods are for handling the side bar functionality. Clicking on any of them changes the color of
     * the button and switches to that tab
     */

    /**
     * when game tab button is pressed
     * @param evt unused
     */
    private void sideButtonGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideButtonGameMousePressed
        // TODO add your handling code here:
        setColor(sideButtonGame);
        sideBarIndicator1.setOpaque(true);
        resetColor(new JPanel[]{sideButtonStats,sideButtonSettings}, new JPanel[]{sideBarIndicator2, sideBarIndicator3});
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "gamePanel");
        settingsPanelIndicatorLabel.setText("");
    }//GEN-LAST:event_sideButtonGameMousePressed


    /**
     * When the stats tab button is pressed
     * @param evt unused
     */
    private void sideButtonStatsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideButtonStatsMousePressed
        // TODO add your handling code here:
        displayStats();
        settingsPanelIndicatorLabel.setText("");
    }//GEN-LAST:event_sideButtonStatsMousePressed

    /**
     * When the settings side button is pressed
     * @param evt
     */
    private void sideButtonSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sideButtonSettingsMousePressed
        // TODO add your handling code here:
        setColor(sideButtonSettings);
        sideBarIndicator3.setOpaque(true);
        resetColor(new JPanel[]{sideButtonStats,sideButtonGame}, new JPanel[]{sideBarIndicator2, sideBarIndicator1});
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "settingsPanel");
    }//GEN-LAST:event_sideButtonSettingsMousePressed

    
    //initialize variables
    String enteredLetters = "";
    String enteredLetter = "";
    String finalEnteredWord = "";
    int rowCount = 0;
    int letterCount = 0;
    String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    boolean userOverride = false;
    
    
    //display the current on the letter on the appropriate box (from left to right)
    private void displayLetter() {
        if(letterCount < 6) {
            myLabels[rowCount*6 + letterCount].setText(enteredLetter);
            letterCount++;
            enteredLetter = "";
        }
        if(garbleInformationBar.getText().length() != 0) garbleInformationBar.setText("");
    }

    //display stats in the stats tab
    private void displayStats(){
        int gamesPlayedHistory = 0;
        int totalGameWins = 0;
        int currWinStreak = 0;
        int longestWinStreak = 0;
        int winPercentage = 0;
        
        try {
            int[] wordlePlayedHistory = StatsUpdater.getStats();
            gamesPlayedHistory = wordlePlayedHistory[0];
            totalGameWins = wordlePlayedHistory[1];
            currWinStreak = wordlePlayedHistory[3];
            longestWinStreak = wordlePlayedHistory[2];
            winPercentage = wordlePlayedHistory[4];
        } catch (Exception ex) {
            Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        totalGamesPlayedLabel.setText(String.valueOf(gamesPlayedHistory));
        totalGameWinsLabel.setText(String.valueOf(totalGameWins));
        longestWinStreakLabel.setText(String.valueOf(longestWinStreak));
        currWinStreakLabel.setText(String.valueOf(currWinStreak));
        winPercentageLabel.setText(String.valueOf(winPercentage));
        
        setColor(sideButtonStats);
        sideBarIndicator2.setOpaque(true);
        resetColor(new JPanel[]{sideButtonGame,sideButtonSettings}, new JPanel[]{sideBarIndicator1, sideBarIndicator3});
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "statsPanel");
    }
    
    public void keyPressed(KeyEvent e) {
        if(Garble.hasGameEnded) return;
        if (Character.isLetter(e.getKeyChar())) {
            String letter = String.valueOf(e.getKeyChar()).toUpperCase();
            enteredLetters += letter;
            enteredLetter = letter;
            displayLetter();
        }
    }

    /**
     * Triggered when the on-screen key "Q" is pressed
     * @param evt
     */
    private void key_qMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_qMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "Q";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_qMousePressed

    /**
     * Triggered when the on-screen key "W" is pressed
     * @param evt
     */
    private void key_wMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_wMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "W";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_wMousePressed

    /**
     * Triggered when the on-screen key "E" is pressed
     * @param evt
     */
    private void key_eMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_eMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "E";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_eMousePressed

    /**
     * Triggered when the on-screen key "R" is pressed
     * @param evt
     */
    private void key_rMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_rMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "R";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_rMousePressed

    /**
     * Triggered when the on-screen key "T" is pressed
     * @param evt
     */
    private void key_tMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_tMousePressed
        // TODO add your handling code here:'
        if(Garble.hasGameEnded) return;
        String letter = "T";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_tMousePressed

    /**
     * Triggered when the on-screen key "Y" is pressed
     * @param evt
     */
    private void key_yMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_yMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "Y";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_yMousePressed

    /**
     * Triggered when the on-screen key "U" is pressed
     * @param evt
     */
    private void key_uMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_uMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "U";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_uMousePressed

    /**
     * Triggered when the on-screen key "I" is pressed
     * @param evt
     */
    private void key_iMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_iMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "I";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_iMousePressed

    /**
     * Triggered when the on-screen key "O" is pressed
     * @param evt
     */
    private void key_oMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_oMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "O";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_oMousePressed

    /**
     * Triggered when the on-screen key "P" is pressed
     * @param evt
     */
    private void key_pMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_pMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "P";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_pMousePressed

    /**
     * Triggered when the on-screen key "A" is pressed
     * @param evt
     */
    private void key_aMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_aMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "A";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_aMousePressed

    /**
     * Triggered when the on-screen key "S" is pressed
     * @param evt
     */
    private void key_sMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_sMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "S";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_sMousePressed

    /**
     * Triggered when the on-screen key "D" is pressed
     * @param evt
     */
    private void key_dMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_dMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "D";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_dMousePressed

    /**
     * Triggered when the on-screen key "F" is pressed
     * @param evt
     */
    private void key_fMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_fMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "F";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_fMousePressed

    /**
     * Triggered when the on-screen key "G" is pressed
     * @param evt
     */
    private void key_gMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_gMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "G";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_gMousePressed

    /**
     * Triggered when the on-screen key "H" is pressed
     * @param evt
     */
    private void key_hMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_hMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "H";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_hMousePressed

    /**
     * Triggered when the on-screen key "J" is pressed
     * @param evt
     */
    private void key_jMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_jMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "J";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_jMousePressed

    /**
     * Triggered when the on-screen key "K" is pressed
     * @param evt
     */
    private void key_kMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_kMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "K";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_kMousePressed

    /**
     * Triggered when the on-screen key "L" is pressed
     * @param evt
     */
    private void key_lMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_lMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "L";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_lMousePressed

    /**
     * Triggered when the on-screen key "Z" is pressed
     * @param evt
     */
    private void key_zMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_zMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "Z";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_zMousePressed

    /**
     * Triggered when the on-screen key "X" is pressed
     * @param evt
     */
    private void key_xMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_xMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "X";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_xMousePressed

    /**
     * Triggered when the on-screen key "C" is pressed
     * @param evt
     */
    private void key_cMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_cMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "C";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_cMousePressed

    /**
     * Triggered when the on-screen key "V" is pressed
     * @param evt
     */
    private void key_vMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_vMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "V";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_vMousePressed

    /**
     * Triggered when the on-screen key "B" is pressed
     * @param evt
     */
    private void key_bMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_bMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "B";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_bMousePressed

    /**
     * Triggered when the on-screen key "N" is pressed
     * @param evt
     */
    private void key_nMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_nMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "N";
        enteredLetters += letter;
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_nMousePressed

    /**
     * Triggered when the on-screen key "M" is pressed
     * @param evt
     */
    private void key_mMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_key_mMousePressed
        // TODO add your handling code here:
        if(Garble.hasGameEnded) return;
        String letter = "M";
        enteredLetters += letter; 
        enteredLetter = letter;
        displayLetter();
    }//GEN-LAST:event_key_mMousePressed

    /**
     * Triggered when the on-screen key "ENTER" is pressed
     * @param evt
     */
    private void button_enterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_enterMousePressed
        
        // check if there are indeed 6 letters in the current row. If there are not then skip
        if(letterCount >= 6) {
            enteredLetters = enteredLetters.substring(0,6);

            //check if the entered letters are a valid word, if it is not a valid word, and it is not a user overwritten word, then skip the entire code
            try {
                if(!WordReader.validWord(enteredLetters.toLowerCase()) && !userOverride){
                    enteredLetters = "";
                    letterCount = 0;
                    for(int i = 0; i < 6; i++) {
                        myLabels[rowCount*6+i].setText("");
                    }
                    
                    garbleInformationBar.setForeground(new Color(135, 37, 61));
                    garbleInformationBar.setText("Not in Word List!");
                    return;
                }
            } catch (Exception ex) {
                Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //grabs color from Garble class to display on the
            garbleGame.takeGuess(enteredLetters.toLowerCase());
            ArrayList<Color> colors = garbleGame.getColors();

            // apply colors to both the display area and the keyboard
            for(int i = 0; i < 6; i++) {
                int currBox = (rowCount)*6 + i;
                myLabels[currBox].setBackground(colors.get(i));
                int currLetterIndex = allLetters.indexOf(myLabels[currBox].getText());
                Color customGreen = new Color(83,141,78);
                Color customYellow = new Color(94, 94, 98);
                if(myLetters[currLetterIndex].getBackground().getRGB() != customGreen.getRGB()) {
                    if(myLetters[currLetterIndex].getBackground().getRGB() != customYellow.getRGB()) {
                        myLetters[currLetterIndex].setBackground(colors.get(i));
                        myLetters[currLetterIndex].setOpaque(true);
                        myLetters[currLetterIndex].setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    }
                }
            }

            //checks if the game has ended and the player has won.
            if(Garble.hasGameEnded) {
                garbleInformationBar.setForeground(new Color(83,141,78));
                garbleInformationBar.setText("You won! Please close the app and reopen if you want to try again.");
                try {
                    StatsUpdater.win();
                } catch (Exception ex) {
                    Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // the following codes are preparing for the next user entry. It resets the pointer and move it to the next row, and clearing previously used variables

            // switch to the next row
            rowCount++;

            // reset the entered letters string
            enteredLetters = "";

            // reset the letter count to 0
            letterCount = 0;
        }

        //checks if the player has lost the game
        if(rowCount == 6 && !Garble.hasGameEnded) {
            garbleInformationBar.setForeground(new Color(181, 159, 59));
            garbleInformationBar.setText("It looks like you lost :( the word is " + Garble.staticWord);
            
            
            try {
                StatsUpdater.lose();
            } catch (Exception ex) {
                Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_enterMousePressed

    /**
     * Triggered when the on-screen key "DEL" is pressed
     * @param evt
     */
    private void button_backspaceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_backspaceMousePressed
        // TODO add your handling code here:

        // deletes the latest letter entered by the player
        if(letterCount > 0) {
            enteredLetters = enteredLetters.substring(0, enteredLetters.length()-1);
            letterCount--;
            myLabels[rowCount*6 + letterCount].setText("");
        }
    }//GEN-LAST:event_button_backspaceMousePressed

    /**
     * Activates when user has pressed the setWord button.
     * @param evt
     */
    private void setWordButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setWordButtonMousePressed
        // TODO add your handling code here:

        // overrides the currently generated random word with the one user has provided;
        // only works if it is a 6 letters word
        String newWordEntered = newWordTextfield.getText();
        if(newWordEntered.length() == 6) {
            newWordTextfield.setText("");
            garbleGame.setWord(newWordEntered);
            settingsPanelIndicatorLabel.setForeground(new Color(83,141,78));
            settingsPanelIndicatorLabel.setText("Word set! Return to game tab to continue.");
            userOverride = true;
        }
    }//GEN-LAST:event_setWordButtonMousePressed

    /**
     * Triggers when the reset button has been pressed
     * @param evt
     */
    private void resetButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetButtonMousePressed

        // deletes all previous history from the text file
        try {
            // TODO add your handling code here:
            StatsUpdater.deleteBrowserHistory();
        } catch (Exception ex) {
            Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        displayStats();
    }//GEN-LAST:event_resetButtonMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JGarble_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JGarble_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JGarble_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JGarble_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JGarble_Interface().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(JGarble_Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    //declaring Array of JLabels for each letter key
    private JLabel[] myLetters = new JLabel[26];

    /**
     * create a method that initializes the array of JLabels
     */
    public void initLetterList() {
        myLetters[0] = key_a;
        myLetters[1] = key_b;
        myLetters[2] = key_c;
        myLetters[3] = key_d;
        myLetters[4] = key_e;
        myLetters[5] = key_f;
        myLetters[6] = key_g;
        myLetters[7] = key_h;
        myLetters[8] = key_i;
        myLetters[9] = key_j;
        myLetters[10] = key_k;
        myLetters[11] = key_l;
        myLetters[12] = key_m;
        myLetters[13] = key_n;
        myLetters[14] = key_o;
        myLetters[15] = key_p;
        myLetters[16] = key_q;
        myLetters[17] = key_r;
        myLetters[18] = key_s;
        myLetters[19] = key_t;
        myLetters[20] = key_u;
        myLetters[21] = key_v;
        myLetters[22] = key_w;
        myLetters[23] = key_x;
        myLetters[24] = key_y;
        myLetters[25] = key_z;
    }
    
    // declare the JLabel array myLabels that stores each of the display boxes
    private JLabel[] myLabels = new JLabel[36];

    /**
     * create a method that initializes the JLabel array
     */
    public void initList() {
        
        myLabels[0] = box_0_0;
        myLabels[1] = box_0_1;
        myLabels[2] = box_0_2;
        myLabels[3] = box_0_3;
        myLabels[4] = box_0_4;
        myLabels[5] = box_0_5;
        myLabels[6] = box_1_0;
        myLabels[7] = box_1_1;
        myLabels[8] = box_1_2;
        myLabels[9] = box_1_3;
        myLabels[10] = box_1_4;
        myLabels[11] = box_1_5;
        myLabels[12] = box_2_0;
        myLabels[13] = box_2_1;
        myLabels[14] = box_2_2;
        myLabels[15] = box_2_3;
        myLabels[16] = box_2_4;
        myLabels[17] = box_2_5;
        myLabels[18] = box_3_0;
        myLabels[19] = box_3_1;
        myLabels[20] = box_3_2;
        myLabels[21] = box_3_3;
        myLabels[22] = box_3_4;
        myLabels[23] = box_3_5;
        myLabels[24] = box_4_0;
        myLabels[25] = box_4_1;
        myLabels[26] = box_4_2;
        myLabels[27] = box_4_3;
        myLabels[28] = box_4_4;
        myLabels[29] = box_4_5;
        myLabels[30] = box_5_0;
        myLabels[31] = box_5_1;
        myLabels[32] = box_5_2;
        myLabels[33] = box_5_3;
        myLabels[34] = box_5_4;
        myLabels[35] = box_5_5;
    }


    /**
     * set the color of a JPanel pane
     * @param pane the JPanel that needs to have its color changed
     */
    private void setColor(JPanel pane) {
        pane.setBackground(new Color(93,99,108));
        
    }

    /**
     * set the color of a pane
     * @param pane the JPanel that needs to have its color changed
     * @param indicators the JPanel that needs to have its color changed
     */
    private void resetColor(JPanel[] pane, JPanel[] indicators) {
        for(int i = 0;i < pane.length; i++){
            pane[i].setBackground(new Color(68,72,80));
        }
        
        for(int i = 0; i < indicators.length; i++){
            indicators[i].setOpaque(false);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel box_0_0;
    private javax.swing.JLabel box_0_1;
    private javax.swing.JLabel box_0_2;
    private javax.swing.JLabel box_0_3;
    private javax.swing.JLabel box_0_4;
    private javax.swing.JLabel box_0_5;
    private javax.swing.JLabel box_1_0;
    private javax.swing.JLabel box_1_1;
    private javax.swing.JLabel box_1_2;
    private javax.swing.JLabel box_1_3;
    private javax.swing.JLabel box_1_4;
    private javax.swing.JLabel box_1_5;
    private javax.swing.JLabel box_2_0;
    private javax.swing.JLabel box_2_1;
    private javax.swing.JLabel box_2_2;
    private javax.swing.JLabel box_2_3;
    private javax.swing.JLabel box_2_4;
    private javax.swing.JLabel box_2_5;
    private javax.swing.JLabel box_3_0;
    private javax.swing.JLabel box_3_1;
    private javax.swing.JLabel box_3_2;
    private javax.swing.JLabel box_3_3;
    private javax.swing.JLabel box_3_4;
    private javax.swing.JLabel box_3_5;
    private javax.swing.JLabel box_4_0;
    private javax.swing.JLabel box_4_1;
    private javax.swing.JLabel box_4_2;
    private javax.swing.JLabel box_4_3;
    private javax.swing.JLabel box_4_4;
    private javax.swing.JLabel box_4_5;
    private javax.swing.JLabel box_5_0;
    private javax.swing.JLabel box_5_1;
    private javax.swing.JLabel box_5_2;
    private javax.swing.JLabel box_5_3;
    private javax.swing.JLabel box_5_4;
    private javax.swing.JLabel box_5_5;
    private javax.swing.JLabel button_backspace;
    private javax.swing.JLabel button_enter;
    private javax.swing.JLabel currWinStreakLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel garbleInformationBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel key_a;
    private javax.swing.JLabel key_b;
    private javax.swing.JLabel key_c;
    private javax.swing.JLabel key_d;
    private javax.swing.JLabel key_e;
    private javax.swing.JLabel key_f;
    private javax.swing.JLabel key_g;
    private javax.swing.JLabel key_h;
    private javax.swing.JLabel key_i;
    private javax.swing.JLabel key_j;
    private javax.swing.JLabel key_k;
    private javax.swing.JLabel key_l;
    private javax.swing.JLabel key_m;
    private javax.swing.JLabel key_n;
    private javax.swing.JLabel key_o;
    private javax.swing.JLabel key_p;
    private javax.swing.JLabel key_q;
    private javax.swing.JLabel key_r;
    private javax.swing.JLabel key_s;
    private javax.swing.JLabel key_t;
    private javax.swing.JLabel key_u;
    private javax.swing.JLabel key_v;
    private javax.swing.JLabel key_w;
    private javax.swing.JLabel key_x;
    private javax.swing.JLabel key_y;
    private javax.swing.JLabel key_z;
    private javax.swing.JLabel longestWinStreakLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField newWordTextfield;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton setWordButton;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JLabel settingsPanelIndicatorLabel;
    private javax.swing.JPanel sideBarIndicator1;
    private javax.swing.JPanel sideBarIndicator2;
    private javax.swing.JPanel sideBarIndicator3;
    private javax.swing.JPanel sideButtonGame;
    private javax.swing.JPanel sideButtonSettings;
    private javax.swing.JPanel sideButtonStats;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JLabel totalGameWinsLabel;
    private javax.swing.JLabel totalGamesPlayedLabel;
    private javax.swing.JLabel winPercentageLabel;
    // End of variables declaration//GEN-END:variables

}

