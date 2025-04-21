import java.io.*;

public class PipedStreams{

    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Error initializing piped streams: " + e.getMessage());
        }
    }

    static class Writer implements Runnable {
        private OutputStream out;

        public Writer(OutputStream out) {
            this.out = out;
        }

        public void run() {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
                String[] messages = {
                        "Hello from writer thread!",
                        "This is a test message.",
                        "Piped streams are working.",
                        "EOF"
                };

                for (String msg : messages) {
                    writer.write(msg);
                    writer.newLine();
                    writer.flush();
                    Thread.sleep(500);
                }

            } catch (IOException | InterruptedException e) {
                System.out.println("Writer error: " + e.getMessage());
            }
        }
    }

    static class Reader implements Runnable {
        private InputStream in;

        public Reader(InputStream in) {
            this.in = in;
        }

        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals("EOF")) break;
                    System.out.println("Reader received: " + line);
                }
            } catch (IOException e) {
                System.out.println("Reader error: " + e.getMessage());
            }
        }
    }
}

