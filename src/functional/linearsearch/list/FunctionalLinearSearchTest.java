package functional.linearsearch.list;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FunctionalLinearSearchTest {
    public static void main(String[] args) {
        int [] zahlen = new int [25];

        for (int i=0; i<25; i++)
            zahlen[i] = (int) (Math.random() *10);

        for (int i : zahlen)
            System.out.print(i + ",");

        List list = LinearSearch.searchint(zahlen,1);

        System.out.println("\n" + list.toString());


        JFrame frame= new JFrame("Weil ich das gesagt HABE!!!");

        frame.setLayout(new GridLayout());

        JLabel array = new JLabel("Array:");
        JLabel ausgabe = new JLabel("Index:" + list.toString());

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel2 = new JPanel((new FlowLayout(FlowLayout.CENTER)));

        panel1.add(array);
        panel2.add(ausgabe);

        frame.add(panel1);
        frame.add(panel2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
