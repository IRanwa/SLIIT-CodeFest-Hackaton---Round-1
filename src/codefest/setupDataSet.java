/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefest;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Imesh Ranawaka
 */
public class setupDataSet {

    private ArrayList<String> Steps;

    private CategoryDataset rtBarChartDS;
    private CategoryDataset liveProDS;
    private CategoryDataset liveErrorDS;
    private CategoryDataset reportProDS;
    private CategoryDataset reportErrorData;
    
    public void setSteps(ArrayList<String> Steps) {
        this.Steps = Steps;
    }
    
    public ChartPanel setupBarChart() {
        if (Steps != null) {
            this.Steps = Steps;
        }
        rtBarChartDS = barData();
        JFreeChart barchart = ChartFactory.createBarChart("LIVE VIEW", "STEP", "Processign Rate",
                rtBarChartDS, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel barpanel = new ChartPanel(barchart);

        return barpanel;
    }

    public ChartPanel setupProcessLineChart() {
        liveProDS = lineProcessData();

        JFreeChart linechart = ChartFactory.createLineChart("Process Rate", "Step", "Rate", liveProDS,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel linepanel = new ChartPanel(linechart);

        return linepanel;
    }

    public ChartPanel setupErrorLineChart() {
        liveErrorDS = lineErrorData();

        JFreeChart linechart = ChartFactory.createLineChart("Error Percentage", "Step", "Percentage", liveErrorDS,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel linepanel = new ChartPanel(linechart);

        return linepanel;
    }

    public ChartPanel reportProcessRate() {
        reportProDS= lineProcessData();
        JFreeChart reportlinechart = ChartFactory.createLineChart("Process Rate Report", "Step", "ProcessRate", reportProDS,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel reportProcess = new ChartPanel(reportlinechart);

        return reportProcess;
    }

    public ChartPanel reportErrorPercentage() {
        reportErrorData = lineErrorData();
        JFreeChart reportlinechart = ChartFactory.createLineChart("Error Percentage Report", "Step", "Percenatge", reportErrorData,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel reportError = new ChartPanel(reportlinechart);

        return reportError;
    }

    private CategoryDataset barData() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String step : Steps ) {
            dataset.addValue(0, step, "Error Percentage");
        }

        for (String step : Steps ) {
            dataset.addValue(0, step, "Processing Rate");
        }

        return dataset;
    }

    private CategoryDataset lineErrorData() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String step : Steps ) {
            dataset.addValue(0, "Error Percentage", step);
        }

        return dataset;
    }

    private CategoryDataset lineProcessData() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String step : Steps ) {
            dataset.addValue(0, "Process Rate", step);
        }

        return dataset;
    }
    
    public CategoryDataset getRtBarChartDS() {
        return rtBarChartDS;
    }

    public CategoryDataset getLiveProDS() {
        return liveProDS;
    }

    public CategoryDataset getLiveErrorDS() {
        return liveErrorDS;
    }

    public CategoryDataset getReportProDS() {
        return reportProDS;
    }

    public CategoryDataset getReportErrorData() {
        return reportErrorData;
    }
}
