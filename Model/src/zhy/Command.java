package zhy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: (le.qiao)
 * @e-mail: qiaolevip@gmail.com
 * @myblog: <a href="http://qiaolevip.iteye.com">http://qiaolevip.iteye.com</a>
 * @date: 2012-10-8
 * 
 */
public class Command
{

	public static void main(String[] args)
	{
		try
		{
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec("cmd /c dir"); // cmd /c calc
			// Process pr = rt.exec("D:\\xunlei\\project.aspx");

			BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));

			String line = null;

			while ((line = input.readLine()) != null)
			{
				System.out.println(line);
			}

			int exitVal = pr.waitFor();
			System.out.println("Exited with error code " + exitVal);

		} catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}