package co.za.izinga.menuupdater.mcdonals.model;

import java.util.Date;

public class OrderForLaterInfo{
    public Date nextOpenTime;
    public Object isSchedulable;
    public String bottomSheetTitleMessage;
    public String bottomSheetSubtitleMessage;
    public String bottomSheetPrimaryButtonMessage;
    public String bottomSheetPrimaryButtonAction;
    public Object bottomSheetSecondaryButtonMessage;
    public Object bottomSheetSecondaryButtonAction;
    public boolean determinedFromBackend;
    public boolean autoSurfaceBottomSheet;
}
