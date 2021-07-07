package LearnGraphStream;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableSample {
    public static void main(String args[]) {
        JFrame f = new JFrame("JTable Sample");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = f.getContentPane();
        Object rows[][] = { { "AMZN", "Amazon", "67 9/16" },
                { "AOL", "America Online", "68 3/4" },
                { "BOUT", "About.com", "56 3/8" },
                { "CDNW", "CDnow", "4 7/16" },
                { "DCLK", "DoubleClick", "87 3/16" },
                { "EBAY", "eBay", "180 7/8" },
                { "EWBX", "EarthWeb", "18 1/4" },
                { "MKTW", "MarketWatch", "29" },
                { "TGLO", "Theglobe.com", "4 15/16" },
                { "YHOO", "Yahoo!", "151 1/8" } };
        Object columns[] = { "Symbol", "Name", "Price" };
        JTable table = new JTable(rows, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        content.add(scrollPane, BorderLayout.CENTER);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
