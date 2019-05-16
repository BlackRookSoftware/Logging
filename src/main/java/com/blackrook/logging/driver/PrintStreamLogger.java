/*******************************************************************************
 * Copyright (c) 2019 Black Rook Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 ******************************************************************************/
package com.blackrook.logging.driver;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import com.blackrook.logging.LoggingDriver;
import com.blackrook.logging.LoggingFactory.LogLevel;
import com.blackrook.logging.util.Utils;

/**
 * A standard logger for outputting to a print stream.
 * @author Matthew Tropiano
 */
public class PrintStreamLogger implements LoggingDriver
{
	/** The print stream to output to. */
	private PrintStream out;
	
	/**
	 * Creates a new print stream logger.
	 * @param out the {@link PrintStream} to output to.
	 */
	public PrintStreamLogger(PrintStream out)
	{
		this.out = out;
	}
	
	@Override
	public void log(Date time, LogLevel level, String source, String message, Throwable throwable)
	{
		if (out == null)
			return;
		
		out.println(String.format("[%tF %tT.%tL] (%s) %s: %s", time, time, time, source, level.name(), message));
		if (throwable != null)
		{
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			throwable.printStackTrace(pw);
			pw.flush();
			pw.close();
			Utils.close(sw);
			out.println(sw);
		}
	}

}
