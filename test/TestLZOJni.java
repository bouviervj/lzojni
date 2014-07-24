/* TestLZOJni.java -- JNI implementation of LZO library

   This file is part of the LZOjni library.

   Copyright (C) 2013 BOUVIER-VOLAILLE Julien
   All Rights Reserved.

   The LZOjni library is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public License as
   published by the Free Software Foundation; either version 2 of
   the License, or (at your option) any later version.

   The LZOjni library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with the LZO library; see the file COPYING.
   If not, write to the Free Software Foundation, Inc.,
   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.

   BOUVIER-VOLAILLE Julien
   <bouviervj@gmail.com>

 */

import org.minilzo.common.LZOjni;

public class TestLZOJni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String aString = new String("ABCABCABCABCABCAB C'est super de compresser des donnees");
		
		byte[] aDataIn = aString.getBytes();
		byte[] aDataOut = new byte[1024];
		int[] outsize = new int[1];
		
		int result = (new LZOjni()).LZOCompress(aDataIn, aDataIn.length, aDataOut, outsize);
		
		System.out.println("Input Length "+aDataIn.length);
		System.out.println("Finished "+result);
		System.out.println("OutputSize "+outsize[0]);
		for (int i=0; i<1024; i++) {
			System.out.printf("%d",aDataOut[i]);
		}
		System.out.println();
		
		byte[] aDataOut2 = new byte[1024];
		
		int out = outsize[0];
		outsize[0] = 1024; // Set available output size
		result = (new LZOjni()).LZODecompress(aDataOut, out, aDataOut2, outsize);
		
		System.out.println("Finished Decompress "+result);
		System.out.println("OutputSize "+outsize[0]);
		for (int i=0; i<1024; i++) {
			System.out.printf("%d",aDataOut2[i]);
		}
		System.out.println();
		String aData = new String(aDataOut2);
		System.out.println(aData);
		
	}

}
