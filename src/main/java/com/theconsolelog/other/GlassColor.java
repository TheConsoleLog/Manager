package com.theconsolelog.other;

public enum GlassColor {
	white (0),
	orange (1),
	magenta (2),
	lightBlue (3),
	yellow (4),
	lightGreen (5),
	pink (6),
	darkGray (7),
	gray (8),
	cyan (9),
	violet (10),
	darkBlue (11),
	brown (12),
	darkGreen (13),
	red (14),
	black (15);

	private final int ID;
	GlassColor (final int value) {
		this.ID = value;
	}
	public int getID () {
		return ID;
	}
}
