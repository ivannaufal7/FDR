package fdr.cyberlabs.fdr.Tirelogy.Techno;//package cyberlabs.fdr.Tirelogy.Techno;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.support.v4.util.LruCache;
//
//import com.android.volley.Cache;
//import com.android.volley.Network;
//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.BasicNetwork;
//import com.android.volley.toolbox.DiskBasedCache;
//import com.android.volley.toolbox.HurlStack;
//import com.android.volley.toolbox.ImageLoader;
//
///**
// * Created by HadianR on 23/11/2016.
// */
//
//public class TechnoRequest {
//    private static TechnoRequest technoRequest;
//    private static Context ctx;
//    private RequestQueue requestQueue;
//    private ImageLoader imageLoader;
//
//    private TechnoRequest(Context ctx) {
//        this.ctx = ctx;
//        this.requestQueue = getRequestQueue();
//
//        imageLoader = new ImageLoader(requestQueue,
//                new ImageLoader.ImageCache() {
//                    private final LruCache<String, Bitmap>
//                    cache = new LruCache<String, Bitmap>(20);
//
//                @Override
//                public Bitmap getBitmap(String url) {
//                    return cache.get(url);
//                }
//                @Override
//                public void putBitmap(String url, Bitmap bitmap) {
//                    cache.put(url, bitmap);
//            }
//        });
//    }
//
//    public static synchronized TechnoRequest getInstance(Context ctx){
//        if (technoRequest == null){
//            technoRequest = new TechnoRequest(ctx);
//        }
//        return technoRequest;
//    }
//
//    public RequestQueue getRequestQueue(){
//        if (requestQueue == null) {
//            Cache cache = new DiskBasedCache(ctx.getCacheDir(), 10 * 1024 * 1024);
//            Network network = new BasicNetwork(new HurlStack());
//            requestQueue = new RequestQueue(cache, network);
//            requestQueue.start();
//        }
//        return requestQueue;
//    }
//
//    public ImageLoader getImageLoader() {
//        return imageLoader;
//
//    }
//}