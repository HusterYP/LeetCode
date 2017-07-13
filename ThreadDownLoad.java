class DownLoad
{
    private static String savePath="";
    private static int threadCount;//线程数量
    private static long totalLength;//文件总长度
    private static URL url;


    public DownLoad(String n,URL url,int threadCount)
    {
        savePath = n;
        DownLoad.url = url;
        DownLoad.threadCount = threadCount;
        try
        {
            URLConnection urlConnection = DownLoad.url.openConnection();
            totalLength = urlConnection.getContentLength();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        setSavePath();//创建保存文件
    }
    public static void setSavePath()
    {
        //得出待下载的文件格式，并创建一个同样的文件存储
        String str = url.getFile();
        String num[] = str.split("\\.");
        String fileKind = "";
        if(num.length!=1)
            fileKind = num[num.length-1];
        else
            fileKind = "html";
        savePath += "1."+fileKind;
    }

    public File getSaveFile()
    {
        return new File(savePath);
    }
    public URL getURL()
    {
        return url;
    }
    public int getThreadCount()
    {
        return threadCount;
    }
    public long getTotalLength()
    {
        return totalLength;
    }
}
class ThreadRun extends Thread
{
    private DownLoad downLoad;
    private Vector<Byte>bytes = new Vector<>();//存储字节,以字节写入
    private long perSum;//每个线程应该下载的字节长度,线程相关
    private long skipCount;//应该跳过的字节长度，线程相关

    public ThreadRun(DownLoad d,int i)//i表示第几条线程
    {
        downLoad = d;
        if(i==d.getThreadCount())//如果是最后一条线程
        {
            perSum = d.getTotalLength() - (d.getTotalLength()/d.getThreadCount())*(i-1);
            skipCount = (d.getTotalLength()/d.getThreadCount())*(i-1);
        }
        else
        {
            perSum = d.getTotalLength() / d.getThreadCount();
            skipCount = (i - 1) * perSum;
        }
    }
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        InputStream in;
        long count = 0;//计数，已经接受了多少字节
        try
        {
            in = downLoad.getURL().openStream();
            in.skip(skipCount);

            byte b[] = new byte[1];
            while ((in.read(b)) != -1&&count<=perSum)
            {
                count++;
                bytes.add(b[0]);
//                Thread.yield();
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(10);
            }
            in.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public Vector<Byte>getVectorBytes()
    {
        return bytes;
    }
}
class BeginThread
{
    private DownLoad downLoad;
    private File file;
    private Vector<Byte>sumByte;
    public BeginThread(DownLoad d)
    {
        downLoad = d;
        file = d.getSaveFile();
        sumByte = new Vector<>();
    }
    public void BeginRun()
    {
        Vector<ThreadRun>threadRun = new Vector<>();
        for(int i=0;i<downLoad.getThreadCount();i++)
        {
            threadRun.add(i,new ThreadRun(downLoad,i+1));
            threadRun.get(i).start();
            try
            {
                threadRun.get(i).join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        for(int i=0;i< downLoad.getThreadCount();i++)
        {
            sumByte.addAll(threadRun.get(i).getVectorBytes());
        }
        try
        {
            FileOutputStream of = new FileOutputStream(file);
            for(int i=0;i<sumByte.size();i++)
                of.write(sumByte.get(i));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


public class Demo
{
    public static void main(String[]args)
    {
        String webAddress = "http://39.108.79.219/";
//        String webAddress = "http://t2.27270.com/uploads/tu/201707/9999/44017f1fbb.jpg";
//        String webAddress = "http://img.boqiicdn.com/Data/Bbs/Users/135/13516/1351667/img32061381071677.gif";
        String savePath = "F:"+File.separator+"Java"+File.separator;
        int threadCount = 1;//线程数量
        try
        {
            URL url = new URL(webAddress);
            DownLoad downLoad = new DownLoad(savePath,url,threadCount);
            BeginThread beginThread = new BeginThread(downLoad);
            beginThread.BeginRun();
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
}