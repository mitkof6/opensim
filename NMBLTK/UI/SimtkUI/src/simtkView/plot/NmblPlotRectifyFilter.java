package simtkView.plot;

import java.io.PrintWriter;

public class NmblPlotRectifyFilter implements NmblPlotDataFilter{
  public NmblPlotRectifyFilter() {
  }

  /**
   * convertData
   *
   * @param pre double[]
   * @return double[]
   */
  public double[] convertData(double[] pre) {
    for (int i=0; i < pre.length; i++)
      pre[i] = Math.abs(pre[i]);
    return pre;
  }

  /**
   * write
   *
   * @param fout PrintWriter
   */
  public void write(PrintWriter fout) {
    fout.println("\t\t\t<filter name=\"rectify\"/>");
  }
}
