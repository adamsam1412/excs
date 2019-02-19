package com.edu.agh.apka;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class App extends JFrame implements ActionListener{

    private final static  String[] words = {"A", "BBBBBBB", "AAAAAAAAAAAAAAAAA", "RANDOM TEXT", "random text"};

    private JButton generateRandomText;
    private JMenuItem openFile;
    private JTextArea textArea;
    private JButton toLowerCase;
    private JButton toUpperCase;

    public App(){
        super("App");
        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponents();
        pack();

    }

    public static void main(String... args){
        App a = new App();
        a.setVisible(true);
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        openFile = new JMenuItem("Open");
        openFile.addActionListener(this);
        fileMenu.add(openFile);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        JPanel textPanel = new JPanel();
        textArea = new JTextArea(15, 35);
        textArea.setText("testowy tekst");
        textPanel.add(textArea);

        add(textPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        toLowerCase = new JButton("To lower case");
        toLowerCase.addActionListener(this);
        buttonPanel.add(toLowerCase);
        toUpperCase = new JButton("To upper case");
        toUpperCase.addActionListener(this);
        buttonPanel.add(toUpperCase);
        generateRandomText = new JButton("Generate");
        generateRandomText.addActionListener(this::handleGenerateRandomText);
        buttonPanel.add(generateRandomText);

        add(buttonPanel, BorderLayout.SOUTH);


    }

    void handleGenerateRandomText(ActionEvent actionEvent){
        System.out.println("Generate clicked");

        Random rand = new Random();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 6; i++) {
            int idx = rand.nextInt(words.length);
            sb.append(words[idx] + " ");
            if((i & 1) == 0)
                sb.append("\n");
        }
        textArea.setText(sb.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == toLowerCase)
            textArea.setText(textArea.getText().toLowerCase());
        else if(source == toUpperCase)
            textArea.setText(textArea.getText().toUpperCase());
        else if(source == openFile){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setCurrentDirectory(new File("."));
            int returnVal = fileChooser.showOpenDialog(null);

            if(returnVal == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Open file" + selectedFile);

                try {
                    List<String> lines = Files.readAllLines(selectedFile.toPath());
                    StringBuilder sb = new StringBuilder();

                    for(String s : lines){
                        sb.append(s + "\n");
                    }

                    textArea.setText(sb.toString());
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}





































