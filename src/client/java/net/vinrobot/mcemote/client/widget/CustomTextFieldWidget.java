package net.vinrobot.mcemote.client.widget;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;

public class CustomTextFieldWidget extends TextFieldWidget {
	private final Runnable tickMethod;

	public CustomTextFieldWidget(final TextRenderer textRenderer, final int x, final int y, final int width, final int height, final Text text) {
		super(textRenderer, x, y, width, height, text);
		this.tickMethod = getTickMethod();
	}

	public void tick() {
		this.tickMethod.run();
	}

	private Runnable getTickMethod() {
		try {
			super.tick();
			return () -> super.tick();
		} catch (final NoSuchMethodError e) {
			e.printStackTrace();
			return () -> {
			};
		}
	}
}
