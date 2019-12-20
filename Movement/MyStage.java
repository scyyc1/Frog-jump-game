package Movement;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Determine the background setting of the game
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {}
	
	public MyStage() {}

	/**
	 * Start the background music
	 */
	public void playMusic()
	{
		String musicFile = "src/Audio/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**
	 * Stop background music
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
