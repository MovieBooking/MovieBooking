/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timshow;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author Better
 */
public class TimshowView extends FXMLView {
    
    public TimshowPresenter getRealPresenter() {
        return (TimshowPresenter) super.getPresenter();
    }
    
}
