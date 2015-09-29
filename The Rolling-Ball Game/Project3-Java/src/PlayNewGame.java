
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * The class {@link PlayNewGame} disappear the cover page.
 * @author Kevin
 *
 */
public class PlayNewGame implements MenuListener {

	private boolean pressed = false;

	@Override
	public void menuCanceled(MenuEvent arg0) {
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		pressed = true;
		Update.setCoverVisibility(pressed);
	}

}
