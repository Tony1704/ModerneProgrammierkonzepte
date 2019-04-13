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

        ArrayList<Map<String, Long>> list;
        list = TestAlgorithms.runTest();

        Iterator arr = list.iterator();

        while (arr.hasNext()) {
            Map<String, Long> map = (Map) arr.next();
            Set schluessel = map.keySet();

            Iterator mapIterator = schluessel.iterator();

            while (mapIterator.hasNext()) {
                String str = (String) mapIterator.next();
                Long l = (Long) map.get(str);
                System.out.println(str + ": " + l/1000000 + "ms");
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
        JPanel panel_bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel panel_bottom_search = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_bottom_search.setBorder(border_search);
        JPanel panel_bottom_sort = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_bottom_sort.setBorder(border_sort);

        JPanel panel_search = new JPanel(new GridLayout(4, 2));
        JPanel panel_sort = new JPanel(new GridLayout(4, 2));

        panel_bottom_search.add(panel_search);
        panel_bottom_search.add(panel_sort);

        panel_bottom.add(panel_bottom_search);
        panel_bottom.add(panel_bottom_sort);

        // Configuration Frame
        this.add(panel_top, BorderLayout.NORTH);
        this.add(panel_bottom, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        UI ui = new UI();
    }
}
