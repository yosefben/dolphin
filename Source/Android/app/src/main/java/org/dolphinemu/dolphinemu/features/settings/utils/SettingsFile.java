package org.dolphinemu.dolphinemu.features.settings.utils;

import androidx.annotation.NonNull;

import org.dolphinemu.dolphinemu.features.settings.model.Settings;
import org.dolphinemu.dolphinemu.features.settings.ui.SettingsActivityView;
import org.dolphinemu.dolphinemu.utils.BiMap;
import org.dolphinemu.dolphinemu.utils.DirectoryInitialization;
import org.dolphinemu.dolphinemu.utils.IniFile;
import org.dolphinemu.dolphinemu.utils.Log;

import java.io.File;

/**
 * Contains static methods for interacting with .ini files in which settings are stored.
 */
public final class SettingsFile
{
  public static final String FILE_NAME_DOLPHIN = "Dolphin";
  public static final String FILE_NAME_GFX = "GFX";
  public static final String FILE_NAME_LOGGER = "Logger";
  public static final String FILE_NAME_GCPAD = "GCPadNew";
  public static final String FILE_NAME_WIIMOTE = "WiimoteNew";

  public static final String KEY_DSP_ENGINE = "DSPEngine";
  public static final String KEY_LAST_PLATFORM_TAB = "LastPlatformTab";

  public static final String KEY_CPU_CORE = "CPUCore";
  public static final String KEY_DUAL_CORE = "CPUThread";
  public static final String KEY_OVERCLOCK_ENABLE = "OverclockEnable";
  public static final String KEY_OVERCLOCK_PERCENT = "Overclock";
  public static final String KEY_SPEED_LIMIT = "EmulationSpeed";
  public static final String KEY_VIDEO_BACKEND = "GFXBackend";

  public static final String KEY_DSP_HLE = "DSPHLE";
  public static final String KEY_DSP_ENABLE_JIT = "EnableJIT";
  public static final String KEY_AUDIO_STRETCH = "AudioStretch";
  public static final String KEY_AUDIO_VOLUME = "Volume";

  public static final String KEY_AUTO_DISC_CHANGE = "AutoDiscChange";
  public static final String KEY_GAME_CUBE_LANGUAGE = "SelectedLanguage";
  public static final String KEY_OVERRIDE_REGION_SETTINGS = "OverrideRegionSettings";
  public static final String KEY_SLOT_A_DEVICE = "SlotA";
  public static final String KEY_SLOT_B_DEVICE = "SlotB";
  public static final String KEY_ENABLE_SAVE_STATES = "EnableSaveStates";
  public static final String KEY_RECURSIVE_ISO_PATHS = "RecursiveISOPaths";
  public static final String KEY_DEFAULT_ISO = "DefaultISO";
  public static final String KEY_NAND_ROOT_PATH = "NANDRootPath";
  public static final String KEY_DUMP_PATH = "DumpPath";
  public static final String KEY_LOAD_PATH = "LoadPath";
  public static final String KEY_RESOURCE_PACK_PATH = "ResourcePackPath";
  public static final String KEY_WII_SD_CARD_PATH = "WiiSDCardPath";

  public static final String KEY_ANALYTICS_ENABLED = "Enabled";
  public static final String KEY_ANALYTICS_PERMISSION_ASKED = "PermissionAsked";

  public static final String KEY_USE_PANIC_HANDLERS = "UsePanicHandlers";
  public static final String KEY_OSD_MESSAGES = "OnScreenDisplayMessages";

  public static final String KEY_SHOW_FPS = "ShowFPS";
  public static final String KEY_INTERNAL_RES = "InternalResolution";
  public static final String KEY_FSAA = "MSAA";
  public static final String KEY_ANISOTROPY = "MaxAnisotropy";
  public static final String KEY_POST_SHADER = "PostProcessingShader";
  public static final String KEY_SCALED_EFB = "EFBScaledCopy";
  public static final String KEY_PER_PIXEL = "EnablePixelLighting";
  public static final String KEY_FORCE_FILTERING = "ForceFiltering";
  public static final String KEY_DISABLE_FOG = "DisableFog";
  public static final String KEY_DISABLE_COPY_FILTER = "DisableCopyFilter";
  public static final String KEY_ARBITRARY_MIPMAP_DETECTION = "ArbitraryMipmapDetection";
  public static final String KEY_WIDE_SCREEN_HACK = "wideScreenHack";
  public static final String KEY_FORCE_24_BIT_COLOR = "ForceTrueColor";
  public static final String KEY_BACKEND_MULTITHREADING = "BackendMultithreading";

  public static final String KEY_STEREO_MODE = "StereoMode";
  public static final String KEY_STEREO_DEPTH = "StereoDepth";
  public static final String KEY_STEREO_CONV = "StereoConvergencePercentage";
  public static final String KEY_STEREO_SWAP = "StereoSwapEyes";

  public static final String KEY_SKIP_EFB = "EFBAccessEnable";
  public static final String KEY_IGNORE_FORMAT = "EFBEmulateFormatChanges";
  public static final String KEY_EFB_TEXTURE = "EFBToTextureEnable";
  public static final String KEY_DEFER_EFB_COPIES = "DeferEFBCopies";
  public static final String KEY_TEXCACHE_ACCURACY = "SafeTextureCacheColorSamples";
  public static final String KEY_GPU_TEXTURE_DECODING = "EnableGPUTextureDecoding";
  public static final String KEY_XFB_TEXTURE = "XFBToTextureEnable";
  public static final String KEY_IMMEDIATE_XFB = "ImmediateXFBEnable";
  public static final String KEY_SKIP_DUPLICATE_XFBS = "SkipDuplicateXFBs";
  public static final String KEY_FAST_DEPTH = "FastDepthCalc";
  public static final String KEY_ASPECT_RATIO = "AspectRatio";
  public static final String KEY_SHADER_COMPILATION_MODE = "ShaderCompilationMode";
  public static final String KEY_WAIT_FOR_SHADERS = "WaitForShadersBeforeStarting";

  public static final String KEY_DEBUG_JITOFF = "JitOff";
  public static final String KEY_DEBUG_JITLOADSTOREOFF = "JitLoadStoreOff";
  public static final String KEY_DEBUG_JITLOADSTOREFLOATINGPOINTOFF = "JitLoadStoreFloatingOff";
  public static final String KEY_DEBUG_JITLOADSTOREPAIREDOFF = "JitLoadStorePairedOff";
  public static final String KEY_DEBUG_JITFLOATINGPOINTOFF = "JitFloatingPointOff";
  public static final String KEY_DEBUG_JITINTEGEROFF = "JitIntegerOff";
  public static final String KEY_DEBUG_JITPAIREDOFF = "JitPairedOff";
  public static final String KEY_DEBUG_JITSYSTEMREGISTEROFF = "JitSystemRegistersOff";
  public static final String KEY_DEBUG_JITBRANCHOFF = "JitBranchOff";
  public static final String KEY_DEBUG_JITREGISTERCACHEOFF = "JitRegisterCacheOff";

  public static final String KEY_GCPAD_TYPE = "SIDevice";
  public static final String KEY_GCPAD_PLAYER_1 = "SIDevice0";
  public static final String KEY_GCPAD_G_TYPE = "PadType";

  public static final String KEY_GCBIND_A = "InputA_";
  public static final String KEY_GCBIND_B = "InputB_";
  public static final String KEY_GCBIND_X = "InputX_";
  public static final String KEY_GCBIND_Y = "InputY_";
  public static final String KEY_GCBIND_Z = "InputZ_";
  public static final String KEY_GCBIND_START = "InputStart_";
  public static final String KEY_GCBIND_CONTROL_UP = "MainUp_";
  public static final String KEY_GCBIND_CONTROL_DOWN = "MainDown_";
  public static final String KEY_GCBIND_CONTROL_LEFT = "MainLeft_";
  public static final String KEY_GCBIND_CONTROL_RIGHT = "MainRight_";
  public static final String KEY_GCBIND_C_UP = "CStickUp_";
  public static final String KEY_GCBIND_C_DOWN = "CStickDown_";
  public static final String KEY_GCBIND_C_LEFT = "CStickLeft_";
  public static final String KEY_GCBIND_C_RIGHT = "CStickRight_";
  public static final String KEY_GCBIND_TRIGGER_L = "InputL_";
  public static final String KEY_GCBIND_TRIGGER_R = "InputR_";
  public static final String KEY_GCBIND_DPAD_UP = "DPadUp_";
  public static final String KEY_GCBIND_DPAD_DOWN = "DPadDown_";
  public static final String KEY_GCBIND_DPAD_LEFT = "DPadLeft_";
  public static final String KEY_GCBIND_DPAD_RIGHT = "DPadRight_";

  public static final String KEY_GCADAPTER_RUMBLE = "AdapterRumble";
  public static final String KEY_GCADAPTER_BONGOS = "SimulateKonga";

  public static final String KEY_EMU_RUMBLE = "EmuRumble";

  public static final String KEY_WIIMOTE_TYPE = "Source";
  public static final String KEY_WIIMOTE_EXTENSION = "Extension";

  // Controller keys for game specific settings
  public static final String KEY_WIIMOTE_G_TYPE = "WiimoteSource";
  public static final String KEY_WIIMOTE_PROFILE = "WiimoteProfile";

  public static final String KEY_WIIBIND_A = "WiimoteA_";
  public static final String KEY_WIIBIND_B = "WiimoteB_";
  public static final String KEY_WIIBIND_1 = "Wiimote1_";
  public static final String KEY_WIIBIND_2 = "Wiimote2_";
  public static final String KEY_WIIBIND_MINUS = "WiimoteMinus_";
  public static final String KEY_WIIBIND_PLUS = "WiimotePlus_";
  public static final String KEY_WIIBIND_HOME = "WiimoteHome_";
  public static final String KEY_WIIBIND_IR_UP = "IRUp_";
  public static final String KEY_WIIBIND_IR_DOWN = "IRDown_";
  public static final String KEY_WIIBIND_IR_LEFT = "IRLeft_";
  public static final String KEY_WIIBIND_IR_RIGHT = "IRRight_";
  public static final String KEY_WIIBIND_IR_FORWARD = "IRForward_";
  public static final String KEY_WIIBIND_IR_BACKWARD = "IRBackward_";
  public static final String KEY_WIIBIND_IR_HIDE = "IRHide_";
  public static final String KEY_WIIBIND_IR_PITCH = "IRTotalPitch";
  public static final String KEY_WIIBIND_IR_YAW = "IRTotalYaw";
  public static final String KEY_WIIBIND_IR_VERTICAL_OFFSET = "IRVerticalOffset";
  public static final String KEY_WIIBIND_SWING_UP = "SwingUp_";
  public static final String KEY_WIIBIND_SWING_DOWN = "SwingDown_";
  public static final String KEY_WIIBIND_SWING_LEFT = "SwingLeft_";
  public static final String KEY_WIIBIND_SWING_RIGHT = "SwingRight_";
  public static final String KEY_WIIBIND_SWING_FORWARD = "SwingForward_";
  public static final String KEY_WIIBIND_SWING_BACKWARD = "SwingBackward_";
  public static final String KEY_WIIBIND_TILT_FORWARD = "TiltForward_";
  public static final String KEY_WIIBIND_TILT_BACKWARD = "TiltBackward_";
  public static final String KEY_WIIBIND_TILT_LEFT = "TiltLeft_";
  public static final String KEY_WIIBIND_TILT_RIGHT = "TiltRight_";
  public static final String KEY_WIIBIND_TILT_MODIFIER = "TiltModifier_";
  public static final String KEY_WIIBIND_SHAKE_X = "ShakeX_";
  public static final String KEY_WIIBIND_SHAKE_Y = "ShakeY_";
  public static final String KEY_WIIBIND_SHAKE_Z = "ShakeZ_";
  public static final String KEY_WIIBIND_DPAD_UP = "WiimoteUp_";
  public static final String KEY_WIIBIND_DPAD_DOWN = "WiimoteDown_";
  public static final String KEY_WIIBIND_DPAD_LEFT = "WiimoteLeft_";
  public static final String KEY_WIIBIND_DPAD_RIGHT = "WiimoteRight_";
  public static final String KEY_WIIBIND_NUNCHUK_C = "NunchukC_";
  public static final String KEY_WIIBIND_NUNCHUK_Z = "NunchukZ_";
  public static final String KEY_WIIBIND_NUNCHUK_UP = "NunchukUp_";
  public static final String KEY_WIIBIND_NUNCHUK_DOWN = "NunchukDown_";
  public static final String KEY_WIIBIND_NUNCHUK_LEFT = "NunchukLeft_";
  public static final String KEY_WIIBIND_NUNCHUK_RIGHT = "NunchukRight_";
  public static final String KEY_WIIBIND_NUNCHUK_SWING_UP = "NunchukSwingUp_";
  public static final String KEY_WIIBIND_NUNCHUK_SWING_DOWN = "NunchukSwingDown_";
  public static final String KEY_WIIBIND_NUNCHUK_SWING_LEFT = "NunchukSwingLeft_";
  public static final String KEY_WIIBIND_NUNCHUK_SWING_RIGHT = "NunchukSwingRight_";
  public static final String KEY_WIIBIND_NUNCHUK_SWING_FORWARD = "NunchukSwingForward_";
  public static final String KEY_WIIBIND_NUNCHUK_SWING_BACKWARD = "NunchukSwingBackward_";
  public static final String KEY_WIIBIND_NUNCHUK_TILT_FORWARD = "NunchukTiltForward_";
  public static final String KEY_WIIBIND_NUNCHUK_TILT_BACKWARD = "NunchukTiltBackward_";
  public static final String KEY_WIIBIND_NUNCHUK_TILT_LEFT = "NunchukTiltLeft_";
  public static final String KEY_WIIBIND_NUNCHUK_TILT_RIGHT = "NunchukTiltRight_";
  public static final String KEY_WIIBIND_NUNCHUK_TILT_MODIFIER = "NunchukTiltModifier_";
  public static final String KEY_WIIBIND_NUNCHUK_SHAKE_X = "NunchukShakeX_";
  public static final String KEY_WIIBIND_NUNCHUK_SHAKE_Y = "NunchukShakeY_";
  public static final String KEY_WIIBIND_NUNCHUK_SHAKE_Z = "NunchukShakeZ_";
  public static final String KEY_WIIBIND_CLASSIC_A = "ClassicA_";
  public static final String KEY_WIIBIND_CLASSIC_B = "ClassicB_";
  public static final String KEY_WIIBIND_CLASSIC_X = "ClassicX_";
  public static final String KEY_WIIBIND_CLASSIC_Y = "ClassicY_";
  public static final String KEY_WIIBIND_CLASSIC_ZL = "ClassicZL_";
  public static final String KEY_WIIBIND_CLASSIC_ZR = "ClassicZR_";
  public static final String KEY_WIIBIND_CLASSIC_MINUS = "ClassicMinus_";
  public static final String KEY_WIIBIND_CLASSIC_PLUS = "ClassicPlus_";
  public static final String KEY_WIIBIND_CLASSIC_HOME = "ClassicHome_";
  public static final String KEY_WIIBIND_CLASSIC_LEFT_UP = "ClassicLeftStickUp_";
  public static final String KEY_WIIBIND_CLASSIC_LEFT_DOWN = "ClassicLeftStickDown_";
  public static final String KEY_WIIBIND_CLASSIC_LEFT_LEFT = "ClassicLeftStickLeft_";
  public static final String KEY_WIIBIND_CLASSIC_LEFT_RIGHT = "ClassicLeftStickRight_";
  public static final String KEY_WIIBIND_CLASSIC_RIGHT_UP = "ClassicRightStickUp_";
  public static final String KEY_WIIBIND_CLASSIC_RIGHT_DOWN = "ClassicRightStickDown_";
  public static final String KEY_WIIBIND_CLASSIC_RIGHT_LEFT = "ClassicRightStickLeft_";
  public static final String KEY_WIIBIND_CLASSIC_RIGHT_RIGHT = "ClassicRightStickRight_";
  public static final String KEY_WIIBIND_CLASSIC_TRIGGER_L = "ClassicTriggerL_";
  public static final String KEY_WIIBIND_CLASSIC_TRIGGER_R = "ClassicTriggerR_";
  public static final String KEY_WIIBIND_CLASSIC_DPAD_UP = "ClassicUp_";
  public static final String KEY_WIIBIND_CLASSIC_DPAD_DOWN = "ClassicDown_";
  public static final String KEY_WIIBIND_CLASSIC_DPAD_LEFT = "ClassicLeft_";
  public static final String KEY_WIIBIND_CLASSIC_DPAD_RIGHT = "ClassicRight_";
  public static final String KEY_WIIBIND_GUITAR_FRET_GREEN = "GuitarGreen_";
  public static final String KEY_WIIBIND_GUITAR_FRET_RED = "GuitarRed_";
  public static final String KEY_WIIBIND_GUITAR_FRET_YELLOW = "GuitarYellow_";
  public static final String KEY_WIIBIND_GUITAR_FRET_BLUE = "GuitarBlue_";
  public static final String KEY_WIIBIND_GUITAR_FRET_ORANGE = "GuitarOrange_";
  public static final String KEY_WIIBIND_GUITAR_STRUM_UP = "GuitarStrumUp_";
  public static final String KEY_WIIBIND_GUITAR_STRUM_DOWN = "GuitarStrumDown_";
  public static final String KEY_WIIBIND_GUITAR_MINUS = "GuitarMinus_";
  public static final String KEY_WIIBIND_GUITAR_PLUS = "GuitarPlus_";
  public static final String KEY_WIIBIND_GUITAR_STICK_UP = "GuitarUp_";
  public static final String KEY_WIIBIND_GUITAR_STICK_DOWN = "GuitarDown_";
  public static final String KEY_WIIBIND_GUITAR_STICK_LEFT = "GuitarLeft_";
  public static final String KEY_WIIBIND_GUITAR_STICK_RIGHT = "GuitarRight_";
  public static final String KEY_WIIBIND_GUITAR_WHAMMY_BAR = "GuitarWhammy_";
  public static final String KEY_WIIBIND_DRUMS_PAD_RED = "DrumsRed_";
  public static final String KEY_WIIBIND_DRUMS_PAD_YELLOW = "DrumsYellow_";
  public static final String KEY_WIIBIND_DRUMS_PAD_BLUE = "DrumsBlue_";
  public static final String KEY_WIIBIND_DRUMS_PAD_GREEN = "DrumsGreen_";
  public static final String KEY_WIIBIND_DRUMS_PAD_ORANGE = "DrumsOrange_";
  public static final String KEY_WIIBIND_DRUMS_PAD_BASS = "DrumsBass_";
  public static final String KEY_WIIBIND_DRUMS_MINUS = "DrumsMinus_";
  public static final String KEY_WIIBIND_DRUMS_PLUS = "DrumsPlus_";
  public static final String KEY_WIIBIND_DRUMS_STICK_UP = "DrumsUp_";
  public static final String KEY_WIIBIND_DRUMS_STICK_DOWN = "DrumsDown_";
  public static final String KEY_WIIBIND_DRUMS_STICK_LEFT = "DrumsLeft_";
  public static final String KEY_WIIBIND_DRUMS_STICK_RIGHT = "DrumsRight_";
  public static final String KEY_WIIBIND_TURNTABLE_GREEN_LEFT = "TurntableGreenLeft_";
  public static final String KEY_WIIBIND_TURNTABLE_RED_LEFT = "TurntableRedLeft_";
  public static final String KEY_WIIBIND_TURNTABLE_BLUE_LEFT = "TurntableBlueLeft_";
  public static final String KEY_WIIBIND_TURNTABLE_GREEN_RIGHT = "TurntableGreenRight_";
  public static final String KEY_WIIBIND_TURNTABLE_RED_RIGHT = "TurntableRedRight_";
  public static final String KEY_WIIBIND_TURNTABLE_BLUE_RIGHT = "TurntableBlueRight_";
  public static final String KEY_WIIBIND_TURNTABLE_MINUS = "TurntableMinus_";
  public static final String KEY_WIIBIND_TURNTABLE_PLUS = "TurntablePlus_";
  public static final String KEY_WIIBIND_TURNTABLE_EUPHORIA = "TurntableEuphoria_";
  public static final String KEY_WIIBIND_TURNTABLE_LEFT_LEFT = "TurntableLeftLeft_";
  public static final String KEY_WIIBIND_TURNTABLE_LEFT_RIGHT = "TurntableLeftRight_";
  public static final String KEY_WIIBIND_TURNTABLE_RIGHT_LEFT = "TurntableRightLeft_";
  public static final String KEY_WIIBIND_TURNTABLE_RIGHT_RIGHT = "TurntableRightRight_";
  public static final String KEY_WIIBIND_TURNTABLE_STICK_UP = "TurntableUp_";
  public static final String KEY_WIIBIND_TURNTABLE_STICK_DOWN = "TurntableDown_";
  public static final String KEY_WIIBIND_TURNTABLE_STICK_LEFT = "TurntableLeft_";
  public static final String KEY_WIIBIND_TURNTABLE_STICK_RIGHT = "TurntableRight_";
  public static final String KEY_WIIBIND_TURNTABLE_EFFECT_DIAL = "TurntableEffDial_";
  public static final String KEY_WIIBIND_TURNTABLE_CROSSFADE_LEFT = "TurntableCrossLeft_";
  public static final String KEY_WIIBIND_TURNTABLE_CROSSFADE_RIGHT = "TurntableCrossRight_";

  public static final String KEY_WII_SD_CARD = "WiiSDCard";
  public static final String KEY_WII_SD_CARD_ALLOW_WRITES = "WiiSDCardAllowWrites";
  public static final String KEY_WIIMOTE_SCAN = "WiimoteContinuousScanning";
  public static final String KEY_WIIMOTE_SPEAKER = "WiimoteEnableSpeaker";

  public static final String KEY_ENABLE_LOGGING = "WriteToFile";
  public static final String KEY_LOG_VERBOSITY = "Verbosity";

  private static BiMap<String, String> sectionsMap = new BiMap<>();

  static
  {
    sectionsMap.add("Hardware", "Video_Hardware");
    sectionsMap.add("Settings", "Video_Settings");
    sectionsMap.add("Enhancements", "Video_Enhancements");
    sectionsMap.add("Stereoscopy", "Video_Stereoscopy");
    sectionsMap.add("Hacks", "Video_Hacks");
    sectionsMap.add("GameSpecific", "Video");
  }

  private SettingsFile()
  {
  }

  /**
   * Reads a given .ini file from disk and returns it.
   * If unsuccessful, outputs an error telling why it failed.
   *
   * @param file The ini file to load the settings from
   * @param ini  The object to load into
   * @param view The current view.
   */
  static void readFile(final File file, IniFile ini, SettingsActivityView view)
  {
    if (!ini.load(file, true))
    {
      Log.error("[SettingsFile] Error reading from: " + file.getAbsolutePath());
      if (view != null)
        view.onSettingsFileNotFound();
    }
  }

  public static void readFile(final String fileName, IniFile ini, SettingsActivityView view)
  {
    readFile(getSettingsFile(fileName), ini, view);

    if (fileName.equals(SettingsFile.FILE_NAME_DOLPHIN))
    {
      addGcPadSettingsIfTheyDontExist(ini);
    }
  }

  /**
   * Reads a given .ini file from disk and returns it.
   * If unsuccessful, outputs an error telling why it failed.
   *
   * @param gameId the id of the game to load settings for.
   * @param ini    The object to load into
   * @param view   The current view.
   */
  public static void readCustomGameSettings(final String gameId, IniFile ini,
          SettingsActivityView view)
  {
    readFile(getCustomGameSettingsFile(gameId), ini, view);
  }

  public static void readGenericGameSettings(final String gameId, IniFile ini,
          SettingsActivityView view)
  {
    readFile(getGenericGameSettingsFile(gameId), ini, view);
  }

  public static void readGenericGameSettingsForAllRegions(final String gameId,
          IniFile ini, SettingsActivityView view)
  {
    readFile(getGenericGameSettingsForAllRegions(gameId), ini, view);
  }

  public static void readWiimoteProfile(final String gameId, IniFile ini, final int padId)
  {
    String profile = gameId + "_Wii" + padId;
    readFile(getWiiProfile(profile), ini, null);
  }

  /**
   * Saves a given .ini file on disk.
   * If unsuccessful, outputs an error telling why it failed.
   *
   * @param fileName The target filename without a path or extension.
   * @param ini      The IniFile we want to serialize.
   * @param view     The current view.
   */
  public static void saveFile(final String fileName, IniFile ini, SettingsActivityView view)
  {
    if (!ini.save(getSettingsFile(fileName)))
    {
      Log.error("[SettingsFile] Error saving to: " + fileName + ".ini");
      if (view != null)
        view.showToastMessage("Error saving " + fileName + ".ini");
    }
  }

  public static void saveCustomGameSettings(final String gameId, IniFile ini)
  {
    IniFile iniCopy = new IniFile(ini);

    // Profile options(wii extension) are not saved, only used to properly display values
    iniCopy.deleteSection(Settings.SECTION_PROFILE);

    for (int i = 0; i < 3; i++)
    {
      String key = SettingsFile.KEY_WIIMOTE_EXTENSION + i;
      if (iniCopy.exists(Settings.SECTION_CONTROLS, key))
      {
        // Special case. Extension gets saved into a controller profile
        String value = iniCopy.getString(Settings.SECTION_CONTROLS, key, "");
        saveCustomWiimoteSetting(gameId, KEY_WIIMOTE_EXTENSION, value, i);
        iniCopy.deleteKey(Settings.SECTION_CONTROLS, key);
      }
    }

    iniCopy.save(getCustomGameSettingsFile(gameId));
  }

  /**
   * Saves the wiimote setting in a profile and enables that profile.
   *
   * @param gameId
   * @param key
   * @param value
   * @param padId
   */
  private static void saveCustomWiimoteSetting(final String gameId, final String key,
          final String value, final int padId)
  {
    String profile = gameId + "_Wii" + padId;
    String wiiConfigPath =
            DirectoryInitialization.getUserDirectory() + "/Config/Profiles/Wiimote/" +
                    profile + ".ini";
    File wiiProfile = getWiiProfile(profile);
    // If it doesn't exist, create it
    boolean wiiProfileExists = wiiProfile.exists();
    if (!wiiProfileExists)
    {
      String defautlWiiProfilePath =
              DirectoryInitialization.getUserDirectory() +
                      "/Config/Profiles/Wiimote/WiimoteProfile.ini";
      DirectoryInitialization.copyFile(defautlWiiProfilePath, wiiConfigPath);
    }

    IniFile wiiProfileIni = new IniFile(wiiConfigPath);

    if (!wiiProfileExists)
    {
      wiiProfileIni.setString(Settings.SECTION_PROFILE, "Device",
              "Android/" + (padId + 4) + "/Touchscreen");
    }

    wiiProfileIni.setString(Settings.SECTION_PROFILE, key, value);
    wiiProfileIni.save(wiiConfigPath);

    // Enable the profile
    File gameSettingsFile = SettingsFile.getCustomGameSettingsFile(gameId);
    IniFile gameSettingsIni = new IniFile(gameSettingsFile);
    gameSettingsIni.setString(Settings.SECTION_CONTROLS, KEY_WIIMOTE_PROFILE + (padId + 1),
            profile);
    gameSettingsIni.save(gameSettingsFile);
  }

  public static String mapSectionNameFromIni(String generalSectionName)
  {
    if (sectionsMap.getForward(generalSectionName) != null)
    {
      return sectionsMap.getForward(generalSectionName);
    }

    return generalSectionName;
  }

  public static String mapSectionNameToIni(String generalSectionName)
  {
    if (sectionsMap.getBackward(generalSectionName) != null)
    {
      return sectionsMap.getBackward(generalSectionName);
    }

    return generalSectionName;
  }

  @NonNull
  public static File getSettingsFile(String fileName)
  {
    return new File(
            DirectoryInitialization.getUserDirectory() + "/Config/" + fileName + ".ini");
  }

  private static File getGenericGameSettingsForAllRegions(String gameId)
  {
    // Use the first 3 chars from the gameId to load the generic game settings for all regions
    gameId = gameId.substring(0, 3);
    return new File(
            DirectoryInitialization.getDolphinInternalDirectory() + "/GameSettings/" +
                    gameId + ".ini");
  }

  private static File getGenericGameSettingsFile(String gameId)
  {
    return new File(
            DirectoryInitialization.getDolphinInternalDirectory() + "/GameSettings/" +
                    gameId + ".ini");
  }

  public static File getCustomGameSettingsFile(String gameId)
  {
    return new File(
            DirectoryInitialization.getUserDirectory() + "/GameSettings/" + gameId + ".ini");
  }

  private static File getWiiProfile(String profile)
  {
    String wiiConfigPath =
            DirectoryInitialization.getUserDirectory() + "/Config/Profiles/Wiimote/" +
                    profile + ".ini";

    return new File(wiiConfigPath);
  }

  private static void addGcPadSettingsIfTheyDontExist(IniFile ini)
  {
    IniFile.Section coreSection = ini.getOrCreateSection(Settings.SECTION_INI_CORE);

    for (int i = 0; i < 4; i++)
    {
      String key = SettingsFile.KEY_GCPAD_TYPE + i;
      if (!coreSection.exists(key))
      {
        // Set GameCube controller 1 to enabled, all others disabled
        coreSection.setInt(key, i == 0 ? 6 : 0);
      }
    }
  }

  public static void firstAnalyticsAdd(boolean enabled)
  {
    IniFile dolphinIni = new IniFile();
    readFile(SettingsFile.FILE_NAME_DOLPHIN, dolphinIni, null);

    dolphinIni.setBoolean(Settings.SECTION_ANALYTICS, KEY_ANALYTICS_ENABLED, enabled);
    dolphinIni.setBoolean(Settings.SECTION_ANALYTICS, KEY_ANALYTICS_PERMISSION_ASKED, true);

    saveFile(SettingsFile.FILE_NAME_DOLPHIN, dolphinIni, null);
  }
}
