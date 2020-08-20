package validators;

import org.testng.asserts.SoftAssert;

import entities.Album;
import entities.Radio;
import lombok.extern.slf4j.Slf4j;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;


@Slf4j
public class RadioValidator extends EntityValidator {
	
	
	
	
	final String className = SongValidator.class.getName();

	
		public void validateRadio(Radio radio, String stationid, SoftAssert sa) {	
			
			/*
			 * Verify if the station id matches with response
			 */
				
			sa.assertTrue(radio.getStationid().equals(stationid), "Station ID doesn't match");
			log.info("Station ID matches with the response");
			
			/*
			 * EXtracting the song object from radio and passing it to Song validator
			 */
							
				final String methodName = new Throwable().getStackTrace()[0].getMethodName();
				
				new SongValidator().validate(radio.getSong(), sa, radio.getStationid(), "stationId");
				log.info("Song validation done!");

			
			
		}	
		}

		

