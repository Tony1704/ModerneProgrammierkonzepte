package app;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UI extends JFrame {

    public UI () {
        super("Weil ich das gesagt HABE!!!");

        Long [] allTimes = new Long[24];
        int i = 0;
        ArrayList<Map<String, Long>> list;
        list = TestAlgorithms.runTest();

        Iterator arr = list.iterator();

        while (arr.hasNext()) {
            Map<String, Long> map = (Map) arr.next();
            Set schluessel = map.keySet();

            Iterator mapIterator = schluessel.iterator();

            while (mapIterator.hasNext()) {
                String str = (String) mapIterator.next();
                Long l = (map.get(str)/1000);

                allTimes[i] = l;

                i++;
            }
        }


        this.setLayout(new BorderLayout());

        // Border
        Border border = BorderFactory.createEtchedBorder();
        Border border_search = BorderFactory.createTitledBorder(border, "Search");
        Border border_sort = BorderFactory.createTitledBorder(border, "Sort");

        // Top JFrame
        JPanel panel_top = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btn_run = new JButton("Run");
        JButton btn_cancel = new JButton("Cancel");

        panel_top.add(btn_run);
        panel_top.add(btn_cancel);

        // Bottom JFrame
        JLabel name = new JLabel("Name:");
        JLabel max = new JLabel("Max Time:");
        JLabel min = new JLabel("Min Time");
        JLabel total = new JLabel("Total Time");

        JLabel FunctionalLinearSearchIndex = new JLabel("Functional LinearSearch Index: ");
        JLabel FunctionalLinearSearchList = new JLabel("Functional LinearSearch List: ");
        JLabel MultithreadedLinearSearchIndex = new JLabel("Multithreaded LinearSearch Index: ");
        JLabel MultithreadedLinearSearchList = new JLabel("Multithreaded LinearSearch List: ");
        JLabel OOLinearSearchIndex = new JLabel("Object Oriented LinearSearch Index: ");
        JLabel OOLinearSearchList = new JLabel("Object Oriented LinearSearch List: ");
        JLabel OOBinarysearch = new JLabel("Object Oriented BinarySearch: ");

        JLabel time01 = new JLabel(allTimes[0].toString());
        JLabel time02 = new JLabel(allTimes[1].toString());
        JLabel time03 = new JLabel(allTimes[2].toString());
        JLabel time11 = new JLabel(allTimes[3].toString());
        JLabel time12 = new JLabel(allTimes[4].toString());
        JLabel time13 = new JLabel(allTimes[5].toString());
        JLabel time21 = new JLabel(allTimes[6].toString());
        JLabel time22 = new JLabel(allTimes[7].toString());
        JLabel time23 = new JLabel(allTimes[8].toString());
        JLabel time31 = new JLabel(allTimes[9].toString());
        JLabel time32 = new JLabel(allTimes[10].toString());
        JLabel time33 = new JLabel(allTimes[11].toString());
        JLabel time41 = new JLabel(allTimes[12].toString());
        JLabel time42 = new JLabel(allTimes[13].toString());
        JLabel time43 = new JLabel(allTimes[14].toString());
        JLabel time51 = new JLabel(allTimes[15].toString());
        JLabel time52 = new JLabel(allTimes[16].toString());
        JLabel time53 = new JLabel(allTimes[17].toString());
        JLabel time61 = new JLabel(allTimes[18].toString());
        JLabel time62 = new JLabel(allTimes[19].toString());
        JLabel time63 = new JLabel(allTimes[20].toString());

        JPanel panel_bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panel_bottom_search = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_bottom_search.setBorder(border_search);
        JPanel panel_bottom_sort = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_bottom_sort.setBorder(border_sort);

        JPanel panel_search = new JPanel(new GridLayout(0, 4));
        JPanel panel_sort = new JPanel(new GridLayout(4, 2));

        panel_search.add(name);
        panel_search.add(max);
        panel_search.add(min);
        panel_search.add(total);
        panel_search.add(FunctionalLinearSearchIndex);
        panel_search.add(time01);
        panel_search.add(time02);
        panel_search.add(time03);
        panel_search.add(FunctionalLinearSearchList);
        panel_search.add(time11);
        panel_search.add(time12);
        panel_search.add(time13);
        panel_search.add(MultithreadedLinearSearchIndex);
        panel_search.add(time21);
        panel_search.add(time22);
        panel_search.add(time23);
        panel_search.add(MultithreadedLinearSearchList);
        panel_search.add(time31);
        panel_search.add(time32);
        panel_search.add(time33);
        panel_search.add(OOLinearSearchIndex);
        panel_search.add(time41);
        panel_search.add(time42);
        panel_search.add(time43);
        panel_search.add(OOLinearSearchList);
        panel_search.add(time51);
        panel_search.add(time52);
        panel_search.add(time53);
        panel_search.add(OOBinarysearch);
        panel_search.add(time61);
        panel_search.add(time62);
        panel_search.add(time63);

        panel_bottom_search.add(panel_search);
        panel_bottom_search.add(panel_sort);

        panel_bottom.add(panel_bottom_search);
        panel_bottom.add(panel_bottom_sort);

        // Configuration Frame
        this.add(panel_top, BorderLayout.NORTH);
        this.add(panel_bottom, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /*public static void main(String[] args) {
        UI ui = new UI();
    }*/
}
