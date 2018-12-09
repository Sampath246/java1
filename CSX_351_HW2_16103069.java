package sampath2;
import java.io.*;
public class CSX_351_HW2_16103069 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\PC\\Downloads\\csx-351-hw2-NemalaSaiKiran99-master(3)\\csx-351-hw2-NemalaSaiKiran99-master\\HW2-dictionary.txt"));
			BufferedReader br1 = new BufferedReader(new FileReader(
					"C:\\Users\\PC\\Downloads\\csx-351-hw2-NemalaSaiKiran99-master(3)\\csx-351-hw2-NemalaSaiKiran99-master\\HW2-keywords.txt"));
			FileWriter fw = new FileWriter(
					"C:\\\\Users\\\\PC\\\\Downloads\\\\csx-351-hw2-NemalaSaiKiran99-master(3)\\\\csx-351-hw2-NemalaSaiKiran99-master\\CSX-16103069.txt");
			BufferedReader br2 = new BufferedReader(new FileReader(
					"C:\\\\Users\\\\PC\\\\Downloads\\\\csx-351-hw2-NemalaSaiKiran99-master(3)\\\\csx-351-hw2-NemalaSaiKiran99-master\\CSX-16103069.txt"));
			String dicarr[] = new String[16000];
			String keyarr[] = new String[84];
			int i = 0, j = 0, m, n;
			int xchanges = 0;
			String str;
			while ((str = br.readLine()) != null) {
				dicarr[i] = str;
				i++;

			}
			while ((str = br1.readLine()) != null) {
				keyarr[j] = str;
				j++;
			}
			// sorting using bubble sort//
			for (i = 0; i < 16000; i++) {
				xchanges = 0;
				for (j = 0; j < 16000 - 1 - i; j++) {
					if ((dicarr[j].compareTo(dicarr[j + 1])) > 0) {
						String temp = dicarr[j];
						dicarr[j] = dicarr[j + 1];
						dicarr[j + 1] = temp;
						xchanges++;

					}
				}
				if (xchanges == 0)
					break;

			}
			for (m = 0; m < 84; m++) {
				xchanges = 0;
				for (n = 0; n < 84 - 1 - m; n++) {
					if ((keyarr[n].compareTo(keyarr[n + 1])) > 0) {
						String temp = keyarr[n];
						keyarr[n] = keyarr[n + 1];
						keyarr[n + 1] = temp;
						xchanges++;
					}
				}
				if (xchanges == 0)
					break;
			}
			int d, kwnf = 0;
			for (m = 0; m < 84; m++) {
				String kw = keyarr[m];
				d = linearsearch(dicarr, keyarr, kw);
				if (d == -1) {
					fw.write("key word is not found =" + kw+"\n");
					kwnf++;

				}
			}
			fw.write("\n\n no of keywords not found is =" + kwnf);
			String s = "";
			fw.close();
			while ((s = br2.readLine()) != null) {
				System.out.println(s);
			}

			br.close();
			br1.close();
			br2.close();
			

		}

		public static int linearsearch(String dicarr[], String keyarr[], String kw) {
			int k = 0;
			while (k < 16000 && kw.compareToIgnoreCase(dicarr[k]) != 0)
				k++;
			if (k < 16000)
				return 1;
			else
				return -1;
		}
	}


