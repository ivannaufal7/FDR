package fdr.cyberlabs.fdr.TireType.TubeType;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderAdapter;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import fdr.cyberlabs.fdr.R;

public class TubeType extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout sliderLayout,sliderLayout2,sliderLayout3;
    private PagerIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tt_tubetype_main);

        sliderLayout = (SliderLayout)findViewById(R.id.slider1);
        sliderLayout2 = (SliderLayout)findViewById(R.id.slider2);
        sliderLayout3 = (SliderLayout)findViewById(R.id.slider3);
//        sliderLayout.setCustomIndicator((PagerIndicator)findViewById(R.id.indicator1));



//        HashMap<String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Gambar 1", "https://s15.postimg.org/4h1qd7zmv/image.jpg");
//        url_maps.put("Gambar 2", "https://s15.postimg.org/9tqkrcnjb/image.jpg");
//        url_maps.put("Gambar 3", "https://s15.postimg.org/eto0zat5z/image.jpg");
//        url_maps.put("Gambar 4", "https://s15.postimg.org/z2bel0sh3/image.jpg");

        HashMap<String,Integer> url_maps = new HashMap<String, Integer>();
        url_maps.put("motor",R.drawable.ss_cub2);
        url_maps.put("sepeda",R.drawable.ss_cub3);
        url_maps.put("angkot",R.drawable.ss_cub4);
        url_maps.put("becak",R.drawable.ss_cub5);
        url_maps.put("mobil",R.drawable.ss_cub);

        for(String name : url_maps.keySet()){
            DefaultSliderView defaultSliderView = new DefaultSliderView(this);

//            TextSliderView textSliderView = new TextSliderView(this);

            // initialize a SliderLayout
            defaultSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            defaultSliderView.bundle(new Bundle());
            defaultSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(defaultSliderView);
            sliderLayout2.addSlider(defaultSliderView);
            sliderLayout3.addSlider(defaultSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(this);

        sliderLayout2.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout2.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        sliderLayout2.setCustomAnimation(new DescriptionAnimation());
        sliderLayout2.setDuration(4000);
        sliderLayout2.addOnPageChangeListener(this);

        sliderLayout3.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout3.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        sliderLayout3.setCustomAnimation(new DescriptionAnimation());
        sliderLayout3.setDuration(4000);
        sliderLayout3.addOnPageChangeListener(this);


    }

    @Override
    protected void onStop(){
        sliderLayout.stopAutoCycle();
        sliderLayout2.stopAutoCycle();
        sliderLayout3.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra")+ "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
