/*
 * Copyright (c)  2005-2008, Stanford University
 * Use of the OpenSim software in source form is permitted provided that the following
 * conditions are met:
 * 	1. The software is used only for non-commercial research and education. It may not
 *     be used in relation to any commercial activity.
 * 	2. The software is not distributed or redistributed.  Software distribution is allowed 
 *     only through https://simtk.org/home/opensim.
 * 	3. Use of the OpenSim software or derivatives must be acknowledged in all publications,
 *      presentations, or documents describing work in which OpenSim or derivatives are used.
 * 	4. Credits to developers may not be removed from executables
 *     created from modifications of the source.
 * 	5. Modifications of source code must retain the above copyright notice, this list of
 *     conditions and the following disclaimer. 
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 *  EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 *  SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 *  TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 *  HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *  OR BUSINESS INTERRUPTION) OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 *  WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.opensim.tracking;

import javax.swing.JComponent;
import org.opensim.modeling.IO;
import org.opensim.modeling.OpenSimObject;
import org.opensim.modeling.Property_Deprecated;
import org.opensim.modeling.PropertySet;

public class ToolCommon {

   public static final String MassFormatStr = "%.3f";
   public static final String TimeFormatStr = "%.3f";
   public static final String CoordinateFormatStr = "%.3f";
   public static final String WeightFormatStr = "%.3f";

    public static void bindProperty(OpenSimObject obj, String propertyName, JComponent comp) { 
      PropertySet pset = obj.getPropertySet();
      Property_Deprecated prop = pset.contains(propertyName);
      if(prop!=null) {
         String comment = prop.getComment();
         if(!comment.equals("")) {
            comp.setToolTipText("<html>"+IO.formatText(comment, "", 120, "<br>")+"<br><br>XML property: <b>"+obj.getConcreteClassName()+" > "+propertyName+"</b></html>");
         }
      } else {
         System.out.println("ToolCommon.bindProperty: Could not find property '"+propertyName+"' in object of type '"+obj.getConcreteClassName()+"'");
      }
   }
}
