package validators;

import java.util.ArrayList;
import java.util.List;

import org.testng.asserts.SoftAssert;

import entities.Album;
import entities.Artist;
import entities.Radio;
import entities.RadioStation;
import entities.Song;
import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;


@Slf4j
public class RadioValidator extends EntityValidator {
	
	
	
	
	final String className = SongValidator.class.getName();

	
		public void validateRadio(Radio radio, String stationid,String seedArtist,String seedLanguage, SoftAssert sa) {	
			
			/*
			 * Verify if the station id matches with response
			 */
				
			sa.assertTrue(radio.getStationid().equals(stationid), "Station ID doesn't match");
			log.info("Station ID matches with the response");
			
			/*
			 * Verify if the artist and language match the json response for every get song  called
			 */
			
			 Song songObject  = radio.getSong();
			 sa.assertTrue(seedLanguage.equals(songObject.getLanguage()));
			log.info("Seed language matches with the language in response");

			//for artist 
			
			/*
			 * creating a list which comprises of artists from json fields - Artists, primary artists and featured artists
			 */
			List<String> artistList = new ArrayList<String>();
			
			//Extracting name from artist 
			List<Artist> artist = songObject.getMoreInfo().getArtistMap().getArtists();
			for(int i=0 ;i<artist.size();i++) {
				String artistName= artist.get(i).getName();
				artistList.add(artistName);
			}
			//Extracting name from primary artist 

			List<Artist> primaryArtist = songObject.getMoreInfo().getArtistMap().getPrimaryArtists();
			if(primaryArtist.size()!=0) {
				for(int i=0 ;i<primaryArtist.size();i++) {
					String artistName= primaryArtist.get(i).getName();
					artistList.add(artistName);
				}
			}
			else {
				log.error("Primary artist size is 0");

			}
			
			//Extracting name from featured artist 
			List<Artist> featuredArtist = songObject.getMoreInfo().getArtistMap().getFeaturedArtists();
			if(featuredArtist.size()!=0) {
				for(int i=0 ;i<featuredArtist.size();i++) {
					String artistName= featuredArtist.get(i).getName();
					artistList.add(artistName);
				}	
			}
			else {
				log.info("Featured artist size is 0");
			}
			
			log.info("printing artist size" +artistList.toString());

			
			
			 	sa.assertTrue(artistList.contains(seedArtist));
				log.info("Seed artist matches with the artists found in response");
			
			
			
			/*
			 * EXtracting the song object from radio and passing it to Song validator
			 */
							
				final String methodName = new Throwable().getStackTrace()[0].getMethodName();
				
				new SongValidator().validate(radio.getSong(), sa, radio.getStationid(), "stationId");
				log.info("Song validation done!");

			
			
		}	
		
		public String getFeaturedstation(RadioStation radio) {
			
			
					
			return radio.getTitle();
			
		}
		
		
		}

		

