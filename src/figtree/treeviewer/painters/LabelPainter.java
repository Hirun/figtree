/*
 * LabelPainter.java
 *
 * Copyright (C) 2006-2014 Andrew Rambaut
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package figtree.treeviewer.painters;

import java.awt.*;
import java.text.NumberFormat;

import figtree.treeviewer.decorators.Decorator;

/**
 * @author Andrew Rambaut
 * @version $Id$
 *
 * $HeadURL$
 *
 * $LastChangedBy$
 * $LastChangedDate$
 * $LastChangedRevision$
 */
public abstract class LabelPainter<T> extends AbstractPainter<T> {
    public static final String NAMES = "Names";
    public static final String NODE_AGES = "Node ages";
    public static final String NODE_HEIGHTS = "Node heights (raw)";
    public static final String BRANCH_TIMES = "Branch times";
    public static final String BRANCH_LENGTHS = "Branch lengths (raw)";
    public static final String SOLID_BOX = "Solid box";
    public static final String SOLID_BOX_ENCODED = "_SOLID_BOX_";

    public enum PainterIntent {
        NODE,
        BRANCH,
        TIP,
        RANGE
    };

    protected LabelPainter(PainterIntent intent) {
        this.intent = intent;
	}

	// Abstract

    public abstract String getDisplayAttribute();

    public abstract void setDisplayAttribute(String displayAttribute);

    public abstract void setTextDecorator(Decorator textDecorator);

    // Getters

	public Paint getForeground() {
		return foreground;
	}

	public Paint getBackground() {
		return background;
	}

	public Paint getBorderPaint() {
		return borderPaint;
	}

	public Stroke getBorderStroke() {
		return borderStroke;
	}

	public Font getFont() {
		return font;
	}

	public NumberFormat getNumberFormat() {
		return numberFormat;
	}

	public boolean isVisible() {
	    return visible;
	}

    // Setters

	public void setBackground(Paint background) {
	    this.background = background;
	    firePainterChanged();
	}

	public void setBorder(Paint borderPaint, Stroke borderStroke) {
	    this.borderPaint = borderPaint;
	    this.borderStroke = borderStroke;
	    firePainterChanged();
	}

	public void setFont(Font font) {
		this.font = font;
	    firePainterChanged();
	}

	public void setForeground(Paint foreground) {
	    this.foreground = foreground;
	    firePainterChanged();
	}

	public void setNumberFormat(NumberFormat numberFormat) {
		this.numberFormat = numberFormat;
	    firePainterChanged();
	}

	public void setBoxSize(int size) {
		// Do nothing
	}

	public void setVisible(boolean visible) {
	    this.visible = visible;
	    firePainterChanged();
	}

    public PainterIntent getIntent() {
        return intent;
    }

    private Paint foreground = Color.BLACK;
	private Paint background = null;
	private Paint borderPaint = null;
	private Stroke borderStroke = null;

	private Font font;
	private boolean visible = true;

	private NumberFormat numberFormat = null;

    private final PainterIntent intent;

}
