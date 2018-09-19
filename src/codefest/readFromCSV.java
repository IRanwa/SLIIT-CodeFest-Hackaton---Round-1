/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author USER
 */
public class readFromCSV {

    public ArrayList<Shiftlist> readFromCSV() {
        ArrayList<Shiftlist> shiftdata = new ArrayList<>();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            File file = new File(formatter.format(date) + ".csv");
            if (!file.exists()) {
                Scanner sc = new Scanner(file);
                sc.useDelimiter(",");

                while (sc.hasNext()) {
                    String shiftId = sc.next();
                    String stepId = sc.next();
                    String employeeID = sc.next();
                    String employeeName = sc.next();
                    String employeeRole = sc.next();

                    Shiftlist sl = new Shiftlist(shiftId, stepId, employeeID, employeeName, employeeRole);

                    shiftdata.add(sl);
                }
                return shiftdata;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(readFromCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        return shiftdata;
    }

    public ChartPanel setupBarChart() {
        CategoryDataset dataset = createDataset();

        JFreeChart barchart = ChartFactory.createBarChart("LIVE VIEW", "STEP", "Processign Rate",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel barpanel = new ChartPanel(barchart);
        return barpanel;
    }

    public ChartPanel setupLineChart() {
        CategoryDataset dataset = linedata();

        JFreeChart linechart = ChartFactory.createLineChart("Process Rate", "Step", "Rate", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel linepanel = new ChartPanel(linechart);

        return linepanel;
    }

    public ChartPanel setupErrorLineChart() {
        CategoryDataset dataset = linedata();

        JFreeChart linechart = ChartFactory.createLineChart("Error Percentage", "Step", "Percentage", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel linepanel = new ChartPanel(linechart);

        return linepanel;
    }

    public ChartPanel reportProcessRate() {
        CategoryDataset reportData = linedata();
        JFreeChart reportlinechart = ChartFactory.createLineChart("Process Rate Report", "Step", "ProcessRate", reportData,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel reportProcess = new ChartPanel(reportlinechart);

        return reportProcess;
    }

    public ChartPanel reportErrorPercentage() {
        CategoryDataset reportData = linedata();
        JFreeChart reportlinechart = ChartFactory.createLineChart("Error Percentage Report", "Step", "Percenatge", reportData,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel reportError = new ChartPanel(reportlinechart);

        return reportError;
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Population in 2005
        dataset.addValue(10, "USA", "2005");
        dataset.addValue(15, "India", "2005");
        dataset.addValue(20, "China", "2005");

        // Population in 2010
        dataset.addValue(15, "USA", "2010");
        dataset.addValue(20, "India", "2010");
        dataset.addValue(25, "China", "2010");

        // Population in 2015
        dataset.addValue(20, "USA", "2015");
        dataset.addValue(25, "India", "2015");
        dataset.addValue(30, "China", "2015");

        return dataset;
    }

    private CategoryDataset linedata() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(10, "USA", "2005");
        dataset.addValue(15, "India", "2005");
        dataset.addValue(20, "China", "2005");

        // Population in 2010
        dataset.addValue(15, "USA", "2010");
        dataset.addValue(20, "India", "2010");
        dataset.addValue(25, "China", "2010");

        // Population in 2015
        dataset.addValue(20, "USA", "2015");
        dataset.addValue(25, "India", "2015");
        dataset.addValue(30, "China", "2015");

        return dataset;
    }

}
