/*******************************************************************************
 * Copyright (c) 2019 Black Rook Software
 * From Black Rook Base https://github.com/BlackRookSoftware/Base 
 * This program and the accompanying materials are made available under 
 * the terms of the MIT License, which accompanies this distribution.
 ******************************************************************************/
package com.blackrook.logging.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Simple IO utility functions.
 * <p>
 * <b>This is a subset of methods from Black Rook Base IOUtils and not meant to be used outside of the library.</b>
 * @author Matthew Tropiano
 */
public final class Utils
{
	/**
	 * Attempts to close a {@link Closeable} object.
	 * If the object is null, this does nothing.
	 * @param c the reference to the closeable object.
	 */
	public static void close(Closeable c)
	{
		if (c == null) return;
		try { c.close(); } catch (IOException e){}
	}

	/**
	 * Attempts to close an {@link AutoCloseable} object.
	 * If the object is null, this does nothing.
	 * @param c the reference to the AutoCloseable object.
	 */
	public static void close(AutoCloseable c)
	{
		if (c == null) return;
		try { c.close(); } catch (Exception e){}
	}

}
