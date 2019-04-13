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
        int i;
        ArrayList<Map<String, Long>> list;
        list = TestAlgorithms.runTest();

        Iterator arr = list.iterator();

        while (arr.hasNext()) {
            i = 0;
            Map<String, Long> map = (Map) arr.next();
            Set schluessel = map.keySet();

            Iterator mapIterator = schluessel.iterator();

            while (mapIterator.hasNext()) {
                String str = (String) mapIterator.next();
                Long l = (Long) (map.get(str)/1000000);

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

        JLabel test = new JLabel(allTimes[0].toString());
        JLabel test1 = new JLabel(allTimes[1].toString());
        JLabel test2 = new JLabel(allTimes[2].toString());

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
        panel_search.add(test);
        panel_search.add(test1);
        panel_search.add(test2);
        panel_search.add(FunctionalLinearSearchList);
        panel_search.add(MultithreadedLinearSearchIndex);
        panel_search.add(MultithreadedLinearSearchList);
        panel_search.add(OOLinearSearchIndex);
        panel_search.add(OOLinearSearchList);
        panel_search.add(OOBinarysearch);


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

    public static void main(String[] args) {
        UI ui = new UI();
    }
}
