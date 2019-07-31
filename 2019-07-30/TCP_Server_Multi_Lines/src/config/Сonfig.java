package config;

import response.MirrorServerResponse;
import response.Protocol;

public class Сonfig {
    public static final int POOL_NUM_THREADS = 5;
    int PORT = 2000;
    Protocol ONE_THREAD_PROTOCOL = new MirrorServerResponse();
}
