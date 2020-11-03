package by.golik;

/**
 * @author Nikita Golik
 */
public class Client extends Thread {
    private boolean reading = false;
    private ChannelPool<AudioChannelPool> pool;
    public Client (ChannelPool<AudioChannelPool> pool) {
        this.pool = pool;
    }
    public void run() { AudioChannelPool channel = null;
        try {
            channel = pool.getResource(500); // изменить на 100
            reading = true;
            System.out.println("Channel Client #" + this.getId()
                    + " took channel #" + channel.getСhannellId());
            channel.using();
        } catch (ResourсeException e) {
            System.out.println("Client #" + this.getId() + " lost ->"
                    + e.getMessage());
        } finally {
            if (channel != null) {
                reading = false;
                System.out.println("Channel Client #" + this.getId() + " : "
                        + channel.getСhannellId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }
    public boolean isReading() {
        return reading;
    }
}
