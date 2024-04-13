/*
 * Copyright (c) 2019, Jos <Malevolentdev@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.statusbars;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;
import net.runelite.client.plugins.statusbars.config.BarMode;
import net.runelite.client.plugins.statusbars.config.BarPosition;

@ConfigGroup(StatusBarsConfig.GROUP)
public interface StatusBarsConfig extends Config
{
	String GROUP = "statusbars";

	@ConfigItem(
		keyName = "leftBarMode",
		name = "Left Bar",
		description = "Configures the left status bar.",
		position = 0
	)
	default BarMode leftBarMode()
	{
		return BarMode.HITPOINTS;
	}

	@ConfigItem(
		keyName = "rightBarMode",
		name = "Right Bar",
		description = "Configures the right status bar.",
		position = 1
	)
	default BarMode rightBarMode()
	{
		return BarMode.PRAYER;
	}

	@ConfigItem(
		keyName = "enableSkillIcon",
		name = "Show icons",
		description = "Adds skill icons at the top of the bars.",
		position = 2
	)
	default boolean enableSkillIcon()
	{
		return true;
	}

	//#region Counter Options
	@ConfigSection(
		name = "Counters",
		description = "Options for the showing of Counters",
		position = 3,
		closedByDefault = false
	)
	String countersSection = "countersSection";

	@ConfigItem(
		keyName = "enableCounter",
		name = "Show counters",
		description = "Shows current numerical value of the status on the bar.",
		position = 1,
		section = countersSection
	)
	default boolean enableCounter()
	{
		return false;
	}

	@ConfigItem(
		keyName = "largeCounterText",
		name = "Large Counter Text",
		description = "If checked, the font for Counters will be larger",
		position = 2,
		section = countersSection
	)
	default boolean largeCounterText()
	{
		return false;
	}

	@Range(
		min = -5,
		max = 100
	)
	@ConfigItem(
		keyName = "counterYPos",
		name = "Vertical Position",
		description = "Percentage down the bar to display the Counters",
		position = 3,
		section = countersSection
	)
	@Units(Units.PERCENT)
	default int counterYOffset()
	{
		return 10;
	}
	//#endregion

	//#region Bar Sizing
	@ConfigSection(
		name = "Sizing",
		description = "Options related to sizes of the bars/borders",
		position = 4,
		closedByDefault = false
	)
	String sizingSection = "sizingSection";

	@Range(
		min = 3,
		max = 50
	)
	@ConfigItem(
		keyName = "barWidth",
		name = "Bar Width",
		description = "The width of each bar. Not used in Fixed UI mode.",
		position = 1,
		section = sizingSection
	)
	@Units(Units.PIXELS)
	default int barWidth()
	{
		return 20;
	}

	@Range(
		min = 0,
		max = 5
	)
	@ConfigItem(
		keyName = "borderSize",
		name = "Border Size",
		description = "The width of the border on each bar",
		position = 2,
		section = sizingSection
	)
	@Units(Units.PIXELS)
	default int borderSize()
	{
		return 1;
	}

	@Range(
		min = 0,
		max = 32
	)
	@ConfigItem(
		keyName = "barGap",
		name = "Gap between Bars",
		description = "The spacing between each bar. Not used in Fixed UI mode.",
		position = 3,
		section = sizingSection
	)
	@Units(Units.PIXELS)
	default int barGap()
	{
		return 4;
	}
	//#endregion

	//#region Restore Options
	@ConfigSection(
		name = "Restoration",
		description = "Restoration related options",
		position = 5,
		closedByDefault = true
	)
	String restorationSection = "restorationSection";

	@ConfigItem(
		keyName = "enableRestorationBars",
		name = "Show restores",
		description = "Visually shows how much will be restored to your status bar.",
		position = 1,
		section = restorationSection
	)
	default boolean enableRestorationBars()
	{
		return true;
	}
	//#endregion

	//#region Display Options
	@ConfigSection(
		name = "Display",
		description = "Display and Visibility related options",
		position = 6,
		closedByDefault = true
	)
	String displaySection = "displaySection";

	@ConfigItem(
		keyName = "hideAfterCombatDelay",
		name = "Hide after combat delay",
		description = "Number of ticks outside of combat after which bars will hide. 0 = always show status bars.",
		position = 1,
		section = displaySection
	)
	@Units(Units.TICKS)
	default int hideAfterCombatDelay()
	{
		return 0;
	}


	@ConfigItem(
		keyName = "overlayPosition",
		name = "Overlay Position",
		description = "Determines where the Bars will be displayed on screen. On Interface will always be active in Classic UI mode.",
		position = 2,
		section = displaySection
	)
	default BarPosition overlayPosition()
	{
		return BarPosition.ON_INTERFACE;
	}

	//#endregion
}
