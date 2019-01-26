

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NumberConverter {
	
	private JFrame frm = new JFrame("Number Converter");
	private JLabel decimalLbl = new JLabel("Decimal");
	private JLabel binaryLbl = new JLabel("Binary");
   private JLabel octalLbl = new JLabel("Octal");
   private JLabel hexLbl = new JLabel("Hexadecimal");
   private JLabel charLbl = new JLabel("Character(s)");
   private JLabel colorLbl = new JLabel("Color");
   private JLabel floatLbl = new JLabel("Float Decimal");
	private JTextField decimalTxt = new JTextField(20);
	private JTextField binaryTxt = new JTextField(20);
   private JTextField octalTxt = new JTextField(20);
   private JTextField hexTxt = new JTextField(20);
   private JTextField charTxt = new JTextField(20);
   private JColorChooser colorChooser = new JColorChooser();
   private JTextField floatTxt = new JTextField(20);
	private JButton colorBtn = new JButton("Choose Color");
   private JButton convertBtn = new JButton("Convert");
   private JButton clearBtn = new JButton("Clear");
	private JPanel pnlMain = new JPanel();
	private JPanel pnlCenter = new JPanel();
   private JTextField[] textFieldArray = new JTextField[]{decimalTxt, binaryTxt, octalTxt, hexTxt, charTxt, floatTxt};

	public NumberConverter() {
		pnlMain.setLayout(new BorderLayout());
		
		pnlCenter.setLayout(new GridLayout(7, 2));
		pnlCenter.add(decimalLbl);
		pnlCenter.add(decimalTxt);
		pnlCenter.add(binaryLbl);
		pnlCenter.add(binaryTxt);
      pnlCenter.add(octalLbl);
		pnlCenter.add(octalTxt);
      pnlCenter.add(hexLbl);
		pnlCenter.add(hexTxt);
      pnlCenter.add(charLbl);
		pnlCenter.add(charTxt);
      //pnlCenter.add(colorLbl);
		//pnlCenter.add(colorBtn);
      pnlCenter.add(floatLbl);
		pnlCenter.add(floatTxt);
      pnlCenter.add(convertBtn);
      pnlCenter.add(clearBtn);
      
      
		
		//pnlMain.add(titleLbl, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		//pnlMain.add(colorBtn, BorderLayout.SOUTH);
      //pnlMain.add(convertBtn, BorderLayout.SOUTH);
      //pnlMain.add(clearBtn, BorderLayout.SOUTH);
      
		/*
		colorBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(frm, "Choose color", pnlMain.getBackground());
               //if(newColor != null)
                  //colorBtn.setBackground(Color.RED);
				
			}
		});
      */
      convertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
            int i;
            String input = "";
            for(i = 0; i < textFieldArray.length; i++){
               if(!textFieldArray[i].getText().isEmpty()){
                  input = textFieldArray[i].getText();
                  break;
               }
            }
            //System.out.println(i);
            //System.out.println(input);  
            switch(i){
               //decimal to all
               case 0: 
                  //string to int
                  //binary:
                  binaryTxt.setText(Integer.toString(Integer.parseInt(input, 10), 2));
                  //octal:
                  octalTxt.setText(Integer.toString(Integer.parseInt(input, 10), 8));
                  //hex:
                  hexTxt.setText(Integer.toString(Integer.parseInt(input, 10), 16));
                  //char:
                  charTxt.setText(Character.toString((char)Integer.parseInt(input, 10)));
                  //float: 
                  floatTxt.setText(Float.toString((float)Integer.parseInt(input, 10)));
               
               //binary to all
               case 1:
                  //decimal:
                  decimalTxt.setText(Integer.toString(Integer.parseInt(input, 2), 10));
                  //octal:
                  octalTxt.setText(Integer.toString(Integer.parseInt(input, 2), 8));
                  //hex:
                  hexTxt.setText(Integer.toString(Integer.parseInt(input, 2), 16));
                  //char:
                  charTxt.setText(Character.toString((char)Integer.parseInt(input, 2)));
                  //float: 
                  floatTxt.setText(Float.toString((float)Integer.parseInt(input, 2)));
                  break;
               //octal to all
               case 2:
                  //decimal:
                  decimalTxt.setText(Integer.toString(Integer.parseInt(input, 8), 10));
                  //binary:
                  binaryTxt.setText(Integer.toString(Integer.parseInt(input, 8), 2));
                  //hex:
                  hexTxt.setText(Integer.toString(Integer.parseInt(input, 8), 16));
                  //char:
                  charTxt.setText(Character.toString((char)Integer.parseInt(input, 8)));
                  //float: 
                  floatTxt.setText(Float.toString((float)Integer.parseInt(input, 8)));
                  break;
               //hex to all
               case 3:
                  //decimal:
                  decimalTxt.setText(Integer.toString(Integer.parseInt(input, 16), 10));
                  //binary:
                  binaryTxt.setText(Integer.toString(Integer.parseInt(input, 16), 2));
                  //octal:
                  octalTxt.setText(Integer.toString(Integer.parseInt(input, 16), 8));
                  //char:
                  charTxt.setText(Character.toString((char)Integer.parseInt(input, 16)));
                  //float: 
                  floatTxt.setText(Float.toString((float)Integer.parseInt(input, 16)));
                  break;
               //char to all
               case 4:
                  //decimal:
                  decimalTxt.setText(Integer.toString(Character.getNumericValue(input.charAt(0))));
                  //binary:
                  binaryTxt.setText(Integer.toBinaryString(Character.getNumericValue(input.charAt(0))));
                  //octal:
                  octalTxt.setText(Integer.toOctalString(Character.getNumericValue(input.charAt(0))));
                  //hex:
                  hexTxt.setText(Integer.toHexString(Character.getNumericValue(input.charAt(0))));
                  //float: 
                  floatTxt.setText(Float.toString(Character.getNumericValue(input.charAt(0))));
                  break;
               //float to all
               case 5: 
                  //decimal:
                  decimalTxt.setText(Integer.toString(Math.round(Float.parseFloat(input))));
                  //binary:
                  binaryTxt.setText(Integer.toBinaryString(Float.floatToIntBits(Float.parseFloat(input))));
                  //octal:
                  octalTxt.setText(Integer.toOctalString(Float.floatToIntBits(Float.parseFloat(input))));
                  //hex:
                  hexTxt.setText(Float.toHexString(Float.floatToIntBits(Float.parseFloat(input))));
                  //char:
                  charTxt.setText(Character.toString((char)Float.parseFloat(input)));      
                  break;
            }				
			}
		});
      clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//set all text fields to empty string
            decimalTxt.setText("");
            binaryTxt.setText("");
            octalTxt.setText("");
            hexTxt.setText("");
            charTxt.setText("");
            floatTxt.setText("");     				
			}
		});
      
		frm.add(pnlMain);
		frm.setPreferredSize(new Dimension(500, 500));
		frm.setVisible(true);
		frm.pack();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		NumberConverter app = new NumberConverter();
	}

}
