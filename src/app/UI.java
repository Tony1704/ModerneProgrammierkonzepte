package app;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * UI class generates User Interface for executing and showing test results
 */

public class UI extends JFrame {

    // Border
    Border border = BorderFactory.createEtchedBorder();
    Border border_search = BorderFactory.createTitledBorder(border, "Linear Search");
    Border border_sort = BorderFactory.createTitledBorder(border, "Quick Sort + Binary Search");

    //private static final long serialVersionUID = 1L;

    /**
     * Generates UI, click Run Or Restart to start the tests
     * <p>
     * Click Cancel or X to close the Window and end the Task
     */
    public UI () {
        super("Search and Sort");
        for ( int i = 0; i<6; i++)
            TestAlgorithms.runTest();

        this.setLayout(new BorderLayout());

        // Top JFrame
        JPanel panel_top = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btn_run = new JButton("Run");
        btn_run.setToolTipText("Run Tests on all Algorithms");
        JButton btn_cancel = new JButton("Cancel");
        btn_cancel.setToolTipText("Cancel Program and close the window");

        panel_top.add(btn_run);
        panel_top.add(btn_cancel);

        ActionListener buttonListener = e -> {
            if (e.getActionCommand().equals("Run")) {
                new UI(TestAlgorithms.runTest(), UI.super.getX(), UI.super.getY());
                UI.super.dispose();
            } else if (e.getActionCommand().equals("Cancel")) {
                System.exit(0);
            }
        };

        btn_run.addActionListener(buttonListener);
        btn_cancel.addActionListener(buttonListener);

        Integer allTimes [] = new Integer[27];

        for (int i = 0; i<allTimes.length; i++ ) {
            allTimes[i] = -1;
        }


        // center JFrame

        // center Panels
        JPanel panel_center = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panel_center_search = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_center_search.setBorder(border_search);
        JPanel panel_center_sort = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_center_sort.setBorder(border_sort);

        JPanel panel_search = new JPanel(new GridLayout(0, 4));
        JPanel panel_sort = new JPanel(new GridLayout(0, 4));

        panel_center_search.add(panel_search);
        panel_center_sort.add(panel_sort);

        panel_center.add(panel_center_search);
        panel_center.add(panel_center_sort);

        // left center panel == Linear Search
        JLabel name = new JLabel("Name");
        JLabel max = new JLabel("Max Time");
        JLabel min = new JLabel("Min Time");
        JLabel total = new JLabel("Average Time");

        JLabel FunctionalLinearSearchIndex = new JLabel("Functional LinearSearch Index: ");
        JLabel FunctionalLinearSearchList = new JLabel("Functional LinearSearch List: ");
        JLabel MultithreadedLinearSearchIndex = new JLabel("Multithreaded LinearSearch Index: ");
        JLabel MultithreadedLinearSearchList = new JLabel("Multithreaded LinearSearch List: ");
        JLabel OOLinearSearchIndex = new JLabel("Object Oriented LinearSearch Index: ");
        JLabel OOLinearSearchList = new JLabel("Object Oriented LinearSearch List: ");

        // Time labels
        // Functional Index
        JLabel time01 = new JLabel(allTimes[0].toString());
        JLabel time02 = new JLabel(allTimes[1].toString());
        JLabel time03 = new JLabel(allTimes[2].toString());
        // Functional List
        JLabel time11 = new JLabel(allTimes[3].toString());
        JLabel time12 = new JLabel(allTimes[4].toString());
        JLabel time13 = new JLabel(allTimes[5].toString());
        // Multithreaded Index
        JLabel time21 = new JLabel(allTimes[6].toString());
        JLabel time22 = new JLabel(allTimes[7].toString());
        JLabel time23 = new JLabel(allTimes[8].toString());
        // Multithreaded List
        JLabel time31 = new JLabel(allTimes[9].toString());
        JLabel time32 = new JLabel(allTimes[10].toString());
        JLabel time33 = new JLabel(allTimes[11].toString());
        // Object Oriented Index
        JLabel time41 = new JLabel(allTimes[12].toString());
        JLabel time42 = new JLabel(allTimes[13].toString());
        JLabel time43 = new JLabel(allTimes[14].toString());
        // Object Oriented List
        JLabel time51 = new JLabel(allTimes[15].toString());
        JLabel time52 = new JLabel(allTimes[16].toString());
        JLabel time53 = new JLabel(allTimes[17].toString());

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


        // right center panel == QuickSort + Binary Search
        JLabel OOQuicksort = new JLabel("Object Oriented Quick Sort: ");
        JLabel MultithreadedBinarysearch = new JLabel("Multithreaded Quick Sort: ");
        JLabel OOBinarysearch = new JLabel("Object Oriented BinarySearch: ");

        // Time labels
        // Multithreaded QuickSort
        JLabel time61 = new JLabel(allTimes[18].toString());
        JLabel time62 = new JLabel(allTimes[19].toString());
        JLabel time63 = new JLabel(allTimes[20].toString());
        // Object Oriented QuickSort
        JLabel time71 = new JLabel(allTimes[21].toString());
        JLabel time72 = new JLabel(allTimes[22].toString());
        JLabel time73 = new JLabel(allTimes[23].toString());
        // Object Oriented BinarySearch
        JLabel time81 = new JLabel(allTimes[24].toString());
        JLabel time82 = new JLabel(allTimes[25].toString());
        JLabel time83 = new JLabel(allTimes[26].toString());

        JLabel name1 = new JLabel("Name");
        JLabel max1 = new JLabel("Max Time");
        JLabel min1 = new JLabel("Min Time");
        JLabel total1 = new JLabel("Average Time");

        panel_sort.add(name1);
        panel_sort.add(max1);
        panel_sort.add(min1);
        panel_sort.add(total1);
        panel_sort.add(OOQuicksort);
        panel_sort.add(time61);
        panel_sort.add(time62);
        panel_sort.add(time63);
        panel_sort.add(MultithreadedBinarysearch);
        panel_sort.add(time71);
        panel_sort.add(time72);
        panel_sort.add(time73);
        panel_sort.add(OOBinarysearch);
        panel_sort.add(time81);
        panel_sort.add(time82);
        panel_sort.add(time83);

        // Time label style
        name.setHorizontalAlignment(JLabel.CENTER);
        max.setHorizontalAlignment(JLabel.CENTER);
        min.setHorizontalAlignment(JLabel.CENTER);
        total.setHorizontalAlignment(JLabel.CENTER);

        time01.setHorizontalAlignment(JLabel.RIGHT);
        time02.setHorizontalAlignment(JLabel.RIGHT);
        time03.setHorizontalAlignment(JLabel.RIGHT);
        time11.setHorizontalAlignment(JLabel.RIGHT);
        time12.setHorizontalAlignment(JLabel.RIGHT);
        time13.setHorizontalAlignment(JLabel.RIGHT);
        time21.setHorizontalAlignment(JLabel.RIGHT);
        time22.setHorizontalAlignment(JLabel.RIGHT);
        time23.setHorizontalAlignment(JLabel.RIGHT);
        time31.setHorizontalAlignment(JLabel.RIGHT);
        time32.setHorizontalAlignment(JLabel.RIGHT);
        time33.setHorizontalAlignment(JLabel.RIGHT);
        time41.setHorizontalAlignment(JLabel.RIGHT);
        time42.setHorizontalAlignment(JLabel.RIGHT);
        time43.setHorizontalAlignment(JLabel.RIGHT);
        time51.setHorizontalAlignment(JLabel.RIGHT);
        time52.setHorizontalAlignment(JLabel.RIGHT);
        time53.setHorizontalAlignment(JLabel.RIGHT);

        name1.setHorizontalAlignment(JLabel.CENTER);
        max1.setHorizontalAlignment(JLabel.CENTER);
        min1.setHorizontalAlignment(JLabel.CENTER);
        total1.setHorizontalAlignment(JLabel.CENTER);

        time61.setHorizontalAlignment(JLabel.RIGHT);
        time62.setHorizontalAlignment(JLabel.RIGHT);
        time63.setHorizontalAlignment(JLabel.RIGHT);
        time71.setHorizontalAlignment(JLabel.RIGHT);
        time72.setHorizontalAlignment(JLabel.RIGHT);
        time73.setHorizontalAlignment(JLabel.RIGHT);
        time81.setHorizontalAlignment(JLabel.RIGHT);
        time82.setHorizontalAlignment(JLabel.RIGHT);
        time83.setHorizontalAlignment(JLabel.RIGHT);

        // Configuration Frame
        this.add(panel_top, BorderLayout.NORTH);
        this.add(panel_center, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);
    }


    public UI (ArrayList<Map<String, Long>> list, int x, int y) {
        super("Search and Sort");


        this.setLayout(new BorderLayout());

        // Top JFrame
        JPanel panel_top = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton btn_run = new JButton("Restart");
        btn_run.setToolTipText("Restart all Tests");
        JButton btn_cancel = new JButton("Cancel");
        btn_cancel.setToolTipText("Cancel Program and close the window");

        panel_top.add(btn_run);
        panel_top.add(btn_cancel);

        ActionListener buttonListener = e -> {
            if (e.getActionCommand().equals("Restart")) {
                new UI(TestAlgorithms.runTest(), UI.super.getX(), UI.super.getY());
                UI.super.dispose();
            } else if (e.getActionCommand().equals("Cancel"))
                System.exit(0);
        };

        btn_run.addActionListener(buttonListener);
        btn_cancel.addActionListener(buttonListener);

        Long [] allTimes = new Long[27];
        int i = 0;

        if (list != null) {
            Iterator<Map<String, Long>> arr = list.iterator();

            while (arr.hasNext()) {
                Map<String, Long> map = (Map<String, Long>) arr.next();
                Set<String> schluessel = map.keySet();

                Iterator<String> mapIterator = schluessel.iterator();

                while (mapIterator.hasNext()) {
                    String str = (String) mapIterator.next();
                    Long l = (map.get(str));

                    allTimes[i] = l;

                    i++;
                }
            }
        }

        // center JFrame

        // center panels
        JPanel panel_center = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panel_center_search = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_center_search.setBorder(border_search);
        JPanel panel_center_sort = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_center_sort.setBorder(border_sort);

        JPanel panel_search = new JPanel(new GridLayout(0, 4));
        JPanel panel_sort = new JPanel(new GridLayout(0, 4));

        panel_center_search.add(panel_search);
        panel_center_sort.add(panel_sort);

        panel_center.add(panel_center_search);
        panel_center.add(panel_center_sort);


        // left center panel == Linear Search
        JLabel name = new JLabel("Name");
        JLabel max = new JLabel("Max Time");
        JLabel min = new JLabel("Min Time");
        JLabel total = new JLabel("Average Time");

        JLabel FunctionalLinearSearchIndex = new JLabel("Functional LinearSearch Index: ");
        JLabel FunctionalLinearSearchList = new JLabel("Functional LinearSearch List: ");
        JLabel MultithreadedLinearSearchIndex = new JLabel("Multithreaded LinearSearch Index: ");
        JLabel MultithreadedLinearSearchList = new JLabel("Multithreaded LinearSearch List: ");
        JLabel OOLinearSearchIndex = new JLabel("Object Oriented LinearSearch Index: ");
        JLabel OOLinearSearchList = new JLabel("Object Oriented LinearSearch List: ");

        // Time labels
        // Functional Index
        JLabel time01 = new JLabel(allTimes[0].toString());
        JLabel time02 = new JLabel(allTimes[1].toString());
        JLabel time03 = new JLabel(allTimes[2].toString());
        // Functional List
        JLabel time11 = new JLabel(allTimes[3].toString());
        JLabel time12 = new JLabel(allTimes[4].toString());
        JLabel time13 = new JLabel(allTimes[5].toString());
        // Multithreaded Index
        JLabel time21 = new JLabel(allTimes[6].toString());
        JLabel time22 = new JLabel(allTimes[7].toString());
        JLabel time23 = new JLabel(allTimes[8].toString());
        // Multithreaded List
        JLabel time31 = new JLabel(allTimes[9].toString());
        JLabel time32 = new JLabel(allTimes[10].toString());
        JLabel time33 = new JLabel(allTimes[11].toString());
        // Object Oriented Index
        JLabel time41 = new JLabel(allTimes[12].toString());
        JLabel time42 = new JLabel(allTimes[13].toString());
        JLabel time43 = new JLabel(allTimes[14].toString());
        // Object Oriented List
        JLabel time51 = new JLabel(allTimes[15].toString());
        JLabel time52 = new JLabel(allTimes[16].toString());
        JLabel time53 = new JLabel(allTimes[17].toString());

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

        // right center panel == QuickSort + Binary Search
        JLabel OOQuicksort = new JLabel("Object Oriented Quick Sort: ");
        JLabel MultithreadedBinarysearch = new JLabel("Multithreaded Quick Sort: ");
        JLabel OOBinarysearch = new JLabel("Object Oriented BinarySearch: ");

        // Time labels
        // Multithreaded QuickSort
        JLabel time61 = new JLabel(allTimes[18].toString());
        JLabel time62 = new JLabel(allTimes[19].toString());
        JLabel time63 = new JLabel(allTimes[20].toString());
        // Object Oriented QuickSort
        JLabel time71 = new JLabel(allTimes[21].toString());
        JLabel time72 = new JLabel(allTimes[22].toString());
        JLabel time73 = new JLabel(allTimes[23].toString());
        // Object Oriented BinarySearch
        JLabel time81 = new JLabel(allTimes[24].toString());
        JLabel time82 = new JLabel(allTimes[25].toString());
        JLabel time83 = new JLabel(allTimes[26].toString());

        JLabel name1 = new JLabel("Name");
        JLabel max1 = new JLabel("Max Time");
        JLabel min1 = new JLabel("Min Time");
        JLabel total1 = new JLabel("Average Time");

        panel_sort.add(name1);
        panel_sort.add(max1);
        panel_sort.add(min1);
        panel_sort.add(total1);
        panel_sort.add(OOQuicksort);
        panel_sort.add(time61);
        panel_sort.add(time62);
        panel_sort.add(time63);
        panel_sort.add(MultithreadedBinarysearch);
        panel_sort.add(time71);
        panel_sort.add(time72);
        panel_sort.add(time73);
        panel_sort.add(OOBinarysearch);
        panel_sort.add(time81);
        panel_sort.add(time82);
        panel_sort.add(time83);

        // Time label style
        name.setHorizontalAlignment(JLabel.CENTER);
        max.setHorizontalAlignment(JLabel.CENTER);
        min.setHorizontalAlignment(JLabel.CENTER);
        total.setHorizontalAlignment(JLabel.CENTER);

        time01.setHorizontalAlignment(JLabel.RIGHT);
        time02.setHorizontalAlignment(JLabel.RIGHT);
        time03.setHorizontalAlignment(JLabel.RIGHT);
        time11.setHorizontalAlignment(JLabel.RIGHT);
        time12.setHorizontalAlignment(JLabel.RIGHT);
        time13.setHorizontalAlignment(JLabel.RIGHT);
        time21.setHorizontalAlignment(JLabel.RIGHT);
        time22.setHorizontalAlignment(JLabel.RIGHT);
        time23.setHorizontalAlignment(JLabel.RIGHT);
        time31.setHorizontalAlignment(JLabel.RIGHT);
        time32.setHorizontalAlignment(JLabel.RIGHT);
        time33.setHorizontalAlignment(JLabel.RIGHT);
        time41.setHorizontalAlignment(JLabel.RIGHT);
        time42.setHorizontalAlignment(JLabel.RIGHT);
        time43.setHorizontalAlignment(JLabel.RIGHT);
        time51.setHorizontalAlignment(JLabel.RIGHT);
        time52.setHorizontalAlignment(JLabel.RIGHT);
        time53.setHorizontalAlignment(JLabel.RIGHT);

        name1.setHorizontalAlignment(JLabel.CENTER);
        max1.setHorizontalAlignment(JLabel.CENTER);
        min1.setHorizontalAlignment(JLabel.CENTER);
        total1.setHorizontalAlignment(JLabel.CENTER);

        time61.setHorizontalAlignment(JLabel.RIGHT);
        time62.setHorizontalAlignment(JLabel.RIGHT);
        time63.setHorizontalAlignment(JLabel.RIGHT);
        time71.setHorizontalAlignment(JLabel.RIGHT);
        time72.setHorizontalAlignment(JLabel.RIGHT);
        time73.setHorizontalAlignment(JLabel.RIGHT);
        time81.setHorizontalAlignment(JLabel.RIGHT);
        time82.setHorizontalAlignment(JLabel.RIGHT);
        time83.setHorizontalAlignment(JLabel.RIGHT);

        // Configuration Frame
        this.add(panel_top, BorderLayout.NORTH);
        this.add(panel_center, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.setLocation(x, y);

        this.setVisible(true);
    }
}