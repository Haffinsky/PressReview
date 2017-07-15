package com.example.rafal.pressreview.Utilities;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.example.rafal.pressreview.Data.NewsListAdapter;
import com.example.rafal.pressreview.Data.ProviderListAdapter;
import com.example.rafal.pressreview.R;

/**
 * Created by Rafal on 7/13/2017.
 */

public class Iconize {

        //set relevant icon if the url contains a specific key
    public static void iconize(String urlExtract, NewsListAdapter.ViewHolder holder, Resources resources){
        if(urlExtract.contains("bbc")) {
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.bbc_news));
        } else if (urlExtract.contains("cnn")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.cnn_news));
        } else if (urlExtract.contains("independent")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.independent_news));
        } else if (urlExtract.contains("dailymail")) {
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.daily_mail_news));
        } else if (urlExtract.contains("indepenent")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.independent_news));
        } else  if (urlExtract.contains("economist")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.economist_news));
        } else if (urlExtract.contains("nytimes")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.newyorktimes_news));
        } else if (urlExtract.contains("wsj")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.wallstreet_news));
        } else if (urlExtract.contains("washingtonpost")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.washingtonpost_news));
        } else  if (urlExtract.contains("aljazeera")){
            holder.providerImageView.setImageDrawable(resources.getDrawable(R.drawable.aljazeera_news));
        } else {
            holder.providerImageView.setImageDrawable(null);
        }
    }
        //set relevant icon if provider_id is equal to a specific key
    public static void iconizeProviderView(String urlExtract, ProviderListAdapter.ViewHolder holder, Resources resources){
        if(urlExtract.equals("abc-news-au")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.abc_news));
        } else if (urlExtract.equals("al-jazeera-english")){
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.aljazeera_news));
        } else if (urlExtract.equals("ars-technica")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.ars_technica));
        } else if (urlExtract.equals("associated-press")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.associated_press_news));
        } else if (urlExtract.equals("bbc-news")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.bbc_news));
        } else if (urlExtract.equals("bbc-sport")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.bbc_sport));
        } else if (urlExtract.equals("bloomberg")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.bloomberg_news));
        } else if (urlExtract.equals("breitbart-news")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.breitbart_news));
        } else if (urlExtract.equals("business-insider")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.business_insider_news));
        } else if (urlExtract.equals("business-insider-uk")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.business_insider_news));
        } else if (urlExtract.equals("bild")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.bild_news));
        } else if (urlExtract.equals("buzzfeed")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.buzzfeed_news));
        } else if (urlExtract.equals("cnbc")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.cnbc_news));
        } else if (urlExtract.equals("cnn")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.cnn_news));
        } else if (urlExtract.equals("daily-mail")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.daily_mail_news));
        } else if (urlExtract.equals("engadget")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.engadget_news));
        } else if (urlExtract.equals("entertainment-weekly")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.entertainment_weekly_news));
        } else if (urlExtract.equals("espn")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.espn_news));
        } else if (urlExtract.equals("espn-cric-info")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.espn_news));
        } else if (urlExtract.equals("financial-times")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.financial_times));
        } else if (urlExtract.equals("football-italia")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.football_italia_news));
        } else if (urlExtract.equals("fortune")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.fortune_news));
        } else if (urlExtract.equals("four-four-two")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.four_four_two_news));
        } else if (urlExtract.equals("fox-sports")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.fox_sports_news));
        } else if (urlExtract.equals("der-tagesspiegel")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.der_tagesspiegel_news));
        } else if (urlExtract.equals("die-zeit")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.die_zeit));
        } else if (urlExtract.equals("focus")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.focus_news));
        } else if (urlExtract.equals("google-news")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.google_news));
        } else if (urlExtract.equals("hacker-news")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.hacker_news));
        } else if (urlExtract.equals("ign")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.ign_news));
        } else if (urlExtract.equals("independent")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.independent_news));
        } else if (urlExtract.equals("mashable")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.mashable_news));
        } else if (urlExtract.equals("metro")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.metro_news));
        } else if (urlExtract.equals("mirror")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.mirror_news));
        } else if (urlExtract.equals("mtv-news")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.mtv_news));
        } else if (urlExtract.equals("mtv-news-uk")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.mtv_news));
        } else if (urlExtract.equals("national-geographic")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.national_geographic_news));
        } else if (urlExtract.equals("new-scientist")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.new_sciencist_news));
        } else if (urlExtract.equals("newsweek")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.newsweek_news));
        } else if (urlExtract.equals("new-york-magazine")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.new_york_magazine));
        } else if (urlExtract.equals("nfl-news")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.nfl_news));
        } else if (urlExtract.equals("polygon")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.polygon_news));
        } else if (urlExtract.equals("recode")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.recode_news));
        } else if (urlExtract.equals("reddit-r-all")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.reddit_news));
        } else if (urlExtract.equals("reuters")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.reuters_news));
        } else if (urlExtract.equals("spiegel-online")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.spiegel_news));
        } else if (urlExtract.equals("talksport")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.talk_sport));
        } else if (urlExtract.equals("techcrunch")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.tech_crunch_news));
        } else if (urlExtract.equals("techradar")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.tech_radar_news));
        } else if (urlExtract.equals("the-economist")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.economist_news));
        } else if (urlExtract.equals("the-guardian-uk")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_guardian_news));
        } else if (urlExtract.equals("the-guardian-au")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_guardian_news));
        } else if (urlExtract.equals("the-huffington-post")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.huffington_post));
        } else if (urlExtract.equals("the-hindu")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_hindu));
        } else if (urlExtract.equals("the-lad-bible")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_lad_bible));
        } else if (urlExtract.equals("the-new-york-times")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.newyorktimes_news));
        } else if (urlExtract.equals("the-next-web")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_next_web));
        } else if (urlExtract.equals("the-sport-bible")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_sport_bible));
        } else if (urlExtract.equals("the-telegraph")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_telegraph_news));
        } else if (urlExtract.equals("the-times-of-india")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_times_of_india));
        } else if (urlExtract.equals("the-verge")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.the_verge));
        } else if (urlExtract.equals("the-wall-street-journal")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.wallstreet_news));
        } else if (urlExtract.equals("the-washington-post")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.washingtonpost_news));
        } else if (urlExtract.equals("time")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.time_news));
        } else if (urlExtract.equals("usa-today")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.usa_today));
        } else if (urlExtract.equals("wired-de")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.wired_de_news));
        } else if (urlExtract.equals("wirtschafts-woche")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.wirtschafts_news_one));
        } else if (urlExtract.equals("gruenderszene")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.gruenderszene_news));
        } else if (urlExtract.equals("handelsblatt")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.handelsblatt_news));
        } else if (urlExtract.equals("t3n")) {
            holder.providerBrandImageView.setImageDrawable(resources.getDrawable(R.drawable.t3n_news));
        }
        else {
            holder.providerBrandImageView.setImageDrawable(null);
        }
    }
        //turn the sysetm bar black (applies to api above 21)
    public void blackenSystemBar(Window window){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLACK);
        }
    }
}
