package backend.languages.simpleEcoreToHtml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

// Source: http://coddicted.com/to-compare-two-folders-recursively-in-java-2/
public class DirectoryComparator {

	public Collection<String> getDiff(String leftDirectory, String righttDirectory)
			throws IOException {
		return getDiff(new File(leftDirectory), new File(righttDirectory));
	}

	public Collection<String> getDiff(File leftDirectory, File rightDirectory) throws IOException {
		final Collection<String> deltas = new ArrayList<>();
		File[] fileList1 = leftDirectory.listFiles();
		File[] fileList2 = rightDirectory.listFiles();
		Arrays.sort(fileList1);
		Arrays.sort(fileList2);
		HashMap<String, File> map1;
		if (fileList1.length < fileList2.length) {
			map1 = new HashMap<String, File>();
			for (final File file : fileList1) {
				map1.put(file.getName(), file);
			}
			deltas.addAll(compareNow(fileList2, map1));
		} else {
			map1 = new HashMap<String, File>();
			for (final File file : fileList2) {
				map1.put(file.getName(), file);
			}
			deltas.addAll(compareNow(fileList1, map1));
		}
		return deltas;
	}

	private Collection<String> compareNow(File[] fileArr,
			HashMap<String, File> map) throws IOException {
		final Collection<String> deltas = new ArrayList<>();
		for (final File leftFile : fileArr) {
			String fileName = leftFile.getName();
			File rightFile = map.get(fileName);
			map.remove(fileName);
			if (rightFile != null) {
				if (rightFile.isDirectory()) {
					deltas.addAll(getDiff(leftFile, rightFile));
				} else {
					String cSum1 = checksum(leftFile);
					String cSum2 = checksum(rightFile);
					if (!cSum1.equals(cSum2)) {
						final Patch patch = DiffUtils.diff(
								FileUtils.readLines(leftFile),
								FileUtils.readLines(rightFile));
						String delta = leftFile.getName() + "\t\t"
								+ "different: " + patch.getDeltas().stream().map(Delta::toString).collect(Collectors.joining(","));
						deltas.add(delta);
					}
				}
			} else {
				if (leftFile.isDirectory()) {
					deltas.addAll(traverseDirectory(leftFile));
				} else {
					String delta = leftFile.getName() + "\t\t" + "only in "
							+ leftFile.getParent();
					deltas.add(delta);
				}
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String n = it.next();
			File fileFrmMap = map.get(n);
			map.remove(n);
			if (fileFrmMap.isDirectory()) {
				traverseDirectory(fileFrmMap);
			} else {
				String delta = fileFrmMap.getName() + "\t\t" + "only in "
						+ fileFrmMap.getParent();
				deltas.add(delta);
			}
		}
		return deltas;
	}

	private Collection<String> traverseDirectory(File dir) {
		final Collection<String> deltas = new ArrayList<>();
		File[] list = dir.listFiles();
		for (int k = 0; k < list.length; k++) {
			if (list[k].isDirectory()) {
				traverseDirectory(list[k]);
			} else {
				String delta = list[k].getName() + "\t\t" + "only in "
						+ list[k].getParent();
				deltas.add(delta);
			}
		}
		return deltas;
	}

	private static String checksum(File file) {
		try {
			InputStream fin = new FileInputStream(file);
			java.security.MessageDigest md5er = MessageDigest
					.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int read;
			do {
				read = fin.read(buffer);
				if (read > 0)
					md5er.update(buffer, 0, read);
			} while (read != -1);
			fin.close();
			byte[] digest = md5er.digest();
			if (digest == null)
				return null;
			String strDigest = "0x";
			for (int i = 0; i < digest.length; i++) {
				strDigest += Integer.toString((digest[i] & 0xff) + 0x100, 16)
						.substring(1).toUpperCase();
			}
			return strDigest;
		} catch (Exception e) {
			return null;
		}
	}

}