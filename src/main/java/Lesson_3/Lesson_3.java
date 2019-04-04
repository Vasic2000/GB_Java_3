package Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lesson_3 {

    public static void main(String[] args) {
//      Создать (если нет) и вычитать файл ~50 байт
        File file = new File("src\\main\\java\\Lesson_3\\OutPut\\50bit.txt");
        if (!file.exists())
            createFile50(file);

        readFromFile(file);

//      Создать (если нет) 5 файлов и переписать всё в 1
        File[] fileN = new File[5];
            for(int i = 0; i < 5; i++) {
                fileN[i] = new File("src\\main\\java\\Lesson_3\\OutPut\\100bit_" + i + ".txt");
                if (!fileN[i].exists())
                    createFile100(fileN[i]);
            }
        File fileSum = new File("src\\main\\java\\Lesson_3\\OutPut\\fileSum.txt");
        if (!file.exists())
            createFile100(file);

        readFrom_5_to_1_File(fileN, fileSum);





    }


    public static void createFile50(File file) {
        File dir = new File("src\\main\\java\\Lesson_3\\OutPut");

        FileWriter fw = null;
        BufferedWriter bw = null;

        dir.mkdirs();
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();

            file.createNewFile();

            for (int i = 0; i < 51; i++) {
                sb.append(i + " ");
                if(i%10 == 0) sb.append("\n");
            }
            sb.append("51\n\n");

            bw.write(sb.toString());

            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createFile100(File file) {
        File dir = new File("src\\main\\java\\Lesson_3\\OutPut");

        FileWriter fw = null;
        BufferedWriter bw = null;

        dir.mkdirs();
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();

            file.createNewFile();

            for (int i = 0; i < 101; i++) {
                sb.append(i + " ");
                if(i%15 == 0) sb.append("\n");
            }
            sb.append("101\n\n");

            bw.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void readFromFile(File file) {

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();

            while(br.ready())
                sb.append((char) br.read());

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFrom_5_to_1_File(File[] fileFrom, File fileTo) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        SequenceInputStream inp = null;
        ArrayList<InputStream> ali = new ArrayList<>();
        try {
            for (int i = 0; i < fileFrom.length; i++)
                ali.add(new FileInputStream(fileFrom[i]));

            inp = new SequenceInputStream(Collections.enumeration(ali));
            fw = new FileWriter(fileTo);
            bw = new BufferedWriter(fw);

            int x;

            while ((x = inp.read()) != -1)
                bw.write(inp.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inp != null) {
                    inp.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//        File file1 = new File("123/testNewName.txt");
//
//        file.renameTo(file1);
//        String[] str = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".txt");
//            }
//        });
//
//        for (String o: str) {
//            System.out.println(o);
//        }


//        long t = System.currentTimeMillis();
//        try(FileInputStream in = new FileInputStream("123/1.txt")) {
//          //  byte[] arr = new byte[512];
//            int x;
//
//            while ( (x = in.read()) != -1 ) {
//                System.out.println((char) x);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(System.currentTimeMillis() - t);

//        String str = "Hello java and C#";
//
//        try (FileOutputStream fos = new FileOutputStream("123/1.txt")) {
//
//            fos.write(str.getBytes());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//       try (InputStreamReader isr = new InputStreamReader(new FileInputStream("123/1.txt"), "UTF-8")) {
//
//          int x;
//
//          while ((x = isr.read()) != -1) {
//              System.out.println((char) x);
//          }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        FileReader fr = null;
//        BufferedReader br = null;
//        try {
//            fr = new FileReader("123/1.txt");
//            br = new BufferedReader(fr);
//
//            String currentLine;
//
//            while ((currentLine = br.readLine()) != null) {
//                System.out.println(currentLine);
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(br != null) {
//                    br.close();
//                }
//                if(fr != null) {
//                    fr.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        PipedInputStream in = null;
//        PipedOutputStream out = null;
//
//        try {
//            in = new PipedInputStream();
//            out= new PipedOutputStream();
//
//            out.connect(in);
//
//            for (int i = 0; i < 100; i++) {
//                out.write(i);
//            }
//
//            int x;
//
//            while ((x = in.read()) != -1) {
//                System.out.print(x + " ");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        ArrayList<InputStream> ali = new ArrayList<>();
//        try {
//            ali.add(new FileInputStream("123/1.txt"));
//            ali.add(new FileInputStream("123/2.txt"));
//            ali.add(new FileInputStream("123/3.txt"));
//
//            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
//
//            int x;
//            while ((x = in.read()) != -1) {
//                System.out.print((char) x);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//            try (RandomAccessFile raf = new RandomAccessFile("123/1.txt", "r")){
//                raf.seek(4);
//                System.out.println((char) raf.read());
//                raf.seek(1);
//                System.out.println((char) raf.read());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//
//            }

//        Students s = new Students(1, "Bob1");
//        Book book = new Book("book");
//        s.book = book;
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
//        oos.writeObject(s);
//        oos.close();

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
//        Students s2 = (Students)ois.readObject();
//        ois.close();
//        s2.info();

