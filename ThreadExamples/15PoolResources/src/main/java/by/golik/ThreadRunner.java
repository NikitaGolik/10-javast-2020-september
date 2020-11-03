package by.golik;

import java.util.LinkedList;

/**
 * @author Nikita Golik
 */
public class ThreadRunner {

    public static void main(String[] args) {

        LinkedList<AudioChannelPool> list = new LinkedList<AudioChannelPool>() {
            {
                this.add(new AudioChannelPool(771));
                this.add(new AudioChannelPool(883));
                this.add(new AudioChannelPool(550));
                this.add(new AudioChannelPool(337));
                this.add(new AudioChannelPool(442));
            }

        };
        ChannelPool<AudioChannelPool> pool = new ChannelPool<>(list);
        for (int i = 0; i < 20; i++) {
            new Client(pool).start();
        }
    }
}
