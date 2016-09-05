package com.andrew.gawoski.summonertimers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/*
Summoner Timers Developed 2016 Andrew Gawoski
 */

public class TeamFormationActivity extends AppCompatActivity {

    //This is the activity we create and fill our class of players from


    FrameLayout ourErrorFrame;
    long original_id;
    String original_region;
    String mostBasicURL;
    String original_key;
    final static String LOG_TAG = "My log tag";

    String region2; // = "NA1";
    String theUserID; //= "63556984"; //The Life of Voy (NA)
    String theAPIKey; // = "c57a78ca-1d80-40a3-9dc9-02a15bca8f89";

    //Unfortunately, it is necessary to have a separate list for mapping riot's champion IDs to our list of champions
    //Possibly the same with summoner spells

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_formation);

        ourErrorFrame = (FrameLayout)findViewById(R.id.formationErrorFrame);
        //Hide the error frame at the start
        ourErrorFrame.setVisibility(View.INVISIBLE);

        original_id = getIntent().getLongExtra("ORIGINAL_ID", 0L);
        original_region = getIntent().getStringExtra("ORIGINAL_REGION");

        Log.i(LOG_TAG, "ID: " + original_id + " REGION: " + original_region);

        //Adjusting parameters for retrofit purposes
        mostBasicURL = "https://" + original_region + ".api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/";


        original_key = getIntent().getStringExtra("ORIGINAL_KEY");

        theUserID = String.valueOf(original_id);

        //Need to grab the region
        region2 = AndrewUtilities.regionConverter(original_region);

        //REMOVE THIS <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
        original_key = "c57a78ca-1d80-40a3-9dc9-02a15bca8f89";

        matchDeserializationMethod(mostBasicURL);

    }

    public void matchDeserializationMethod(String theRequestURL){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(theRequestURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        GameResponseService service = retrofit.create(GameResponseService.class);

        Call<ResponseGame> queryResponseCall = service.getResponseGame(region2, theUserID, original_key);

        //Call retrofit asynchronously
        queryResponseCall.enqueue(new Callback<ResponseGame>(){
            //public void onResponse(Response<ResponseGame>response){
            public void onResponse(Response<ResponseGame>response){
                //get the response from response.body
                Log.i(LOG_TAG, "Inside onResponse");
                Log.i(LOG_TAG, "Our response code is " + response.code());

                Integer theResponseCode = response.code();

                if(theResponseCode.equals(400)){
                    //Code 400
                    Toast errorFailureToast = Toast.makeText(getApplication(), "Error 400 - Bad Request", Toast.LENGTH_LONG);
                    errorFailureToast.show();
                    ourErrorFrame.setVisibility(View.VISIBLE);
                    Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                    startActivity(returnIntent);

                }else if(theResponseCode.equals(401)){
                    //Code 401
                    Toast errorFailureToast = Toast.makeText(getApplication(), "Error 401 - Unauthorized", Toast.LENGTH_LONG);
                    errorFailureToast.show();
                    ourErrorFrame.setVisibility(View.VISIBLE);
                    Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                    startActivity(returnIntent);

                }else if(theResponseCode.equals(404)){
                    //Code 404
                    Toast errorFailureToast = Toast.makeText(getApplication(), "Error 404 - Not Found", Toast.LENGTH_LONG);
                    errorFailureToast.show();
                    ourErrorFrame.setVisibility(View.VISIBLE);
                    Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                    startActivity(returnIntent);

                }else if(theResponseCode.equals(415)){
                    //Code 415
                    Toast errorFailureToast = Toast.makeText(getApplication(), "Error 415 - Unsupported Media Type", Toast.LENGTH_LONG);
                    errorFailureToast.show();
                    ourErrorFrame.setVisibility(View.VISIBLE);
                    Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                    startActivity(returnIntent);

                }else if(theResponseCode.equals(429)){
                    //Code 429
                    Toast errorFailureToast = Toast.makeText(getApplication(), "Error 429 - Rate Limit Exceeded", Toast.LENGTH_LONG);
                    errorFailureToast.show();
                    ourErrorFrame.setVisibility(View.VISIBLE);
                    Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                    startActivity(returnIntent);

                }else if(theResponseCode.equals(500)){
                    //Code 500
                    Toast errorFailureToast = Toast.makeText(getApplication(), "Error 500 - Internal Server Error", Toast.LENGTH_LONG);
                    errorFailureToast.show();
                    ourErrorFrame.setVisibility(View.VISIBLE);
                    Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                    startActivity(returnIntent);

                }else if(theResponseCode.equals(503)){
                    //Code 500
                    Toast errorFailureToast = Toast.makeText(getApplication(), "Error 503 - Service Unavailable", Toast.LENGTH_LONG);
                    errorFailureToast.show();
                    ourErrorFrame.setVisibility(View.VISIBLE);
                    Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                    startActivity(returnIntent);
                }else if(theResponseCode.equals(200)){
                    //We're successful, hooray!
                    Log.i(LOG_TAG, "I'M MAKING A NOTE HERE- HUGE SUCCESS.");
                    //Do all the things

                    //Check to see if we have a game mode
                    ResponseGame ourFreshestResponse = response.body();
                    Long summonersRiftID = 11L;
                    if(ourFreshestResponse.getParticipants().size() == 10 && summonersRiftID.equals(ourFreshestResponse.getMapId())){
                        //We have a 10 players on summoner's rift

                        //Figure out which team our user is on
                        Long playerTeamID = 0L;
                        Long playerID = Long.parseLong(theUserID);
                        int userIndex;
                        for(int i=0; i < ourFreshestResponse.getParticipants().size(); i++){
                            if(playerID.equals(ourFreshestResponse.getParticipants().get(i).getSummonerId())){
                                //The IDs are the same,
                                playerTeamID = ourFreshestResponse.getParticipants().get(i).getTeamId();
                            }
                        }
                        //Now we need to make a team of everyone not on the player's team
                        TeamData ourTempTeam = new TeamData();
                        List<Participant> ourParticipants = ourFreshestResponse.getParticipants();
                        for(int j=0; j < ourParticipants.size(); j++){
                            if(ourParticipants.get(j).getTeamId() != playerTeamID){
                                //They have a different team so we actually care
                                //Convert the riot api participant to our playerdata object
                                PlayerData theTempPlayer = AndrewUtilities.createPlayerFromAPI(ourParticipants.get(j));
                                //Add our temp player to our temp team list
                                ourTempTeam.getTeamList().add(theTempPlayer);
                            }
                            //We don't care and do nothing.
                        }
                        //After parsing the participants for the other team we set our singleton to our temp team object and begin the timer activity
                        TeamData.getInstance().setTeam(ourTempTeam.getTeamList());
                        Intent onwardsToTimerIntent = new Intent(getApplicationContext(),TimerActivity.class);
                        startActivity(onwardsToTimerIntent);

                    }else{
                        Toast unsupportedMapToast = Toast.makeText(getApplicationContext(), "Unsupported map or number of players", Toast.LENGTH_LONG);
                        unsupportedMapToast.show();
                        Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                        startActivity(returnIntent);
                    }

                    Log.i(LOG_TAG, "S0: " + ourFreshestResponse.getParticipants().get(0).getSummonerName());
                    Log.i(LOG_TAG, "S1: " + ourFreshestResponse.getParticipants().get(1).getSummonerName());
                    Log.i(LOG_TAG, "S2: " + ourFreshestResponse.getParticipants().get(2).getSummonerName());
                }
            }
            //End of onResponse

            @Override
            public void onFailure(Throwable t) {
                //We've failed somehow
                Log.i(LOG_TAG, "inside onFailure");
                t.printStackTrace();

                Toast errorFailureToast = Toast.makeText(getApplication(), "Failed to reach the server...", Toast.LENGTH_LONG);
                errorFailureToast.show();
                ourErrorFrame.setVisibility(View.VISIBLE);
                Intent returnIntent = new Intent(getApplication(), MainActivity.class);
                startActivity(returnIntent);
            }
        });
    }

    public interface GameResponseService{
        @GET("{theRegion}/{theID}")
        Call<ResponseGame> getResponseGame(@Path("theRegion")String region2,
                                           @Path("theID") String theUserID,
                                           @Query("api_key") String theAPIKey);
    }
}