function ref = ref_dataFormatDelaware()

ref.c3dAnalogLabels.grf = {'F1X','F1Y','F1Z','M1X','M1Y','M1Z', ...
                           'F2X','F2Y','F2Z','M2X','M2Y','M2Z'};

ref.c3dAnalogLabels.groundForcePattern = {'F%dX', 'F%dY', 'F%dZ'};

ref.c3dAnalogLabels.emg = {'RBIC', 'RTA', 'ES', 'GMED', 'GMAX', 'VASL', 'RF', 'HAMS', 
                           'RDEL', 'RGAS', 'RSOL', 'LSOL', 'LGAS', 'LTA', 'LHAM', 'LRF'};

ref.c3dVideoLabels.markers = ...
   {'RASI', 'LASI',         ... % ASIS
    'VSAC',                 ... % V.Sacral
    'RTHI', 'LTHI',         ... % Thigh (Upper, Front, Rear)
    'RSHA', 'LSHA',         ... % Shank (Upper, Front, Rear)
    'RHEE', 'RMID', 'RTOE', ... % Heel, Midfoot (Sup, Lat), Toe (Tip, Lat, Med)
    'LHEE', 'LMID', 'LTOE', ...
    'STER',                 ... % Sternum
    'RACR', 'LACR',         ... % Acromium
    'RBIC', 'LBIC',         ... % Bicep
    'RELB', 'LELB',         ... % Elbow
    'RWRI', 'LWRI',         ... % Wrist (Med, Lat)
    'RTEM', 'LTEM',         ... % Temple
    'TPHE'};                    % Top.Head

ref.c3dVideoLabels.jntcenters.L = {};
ref.c3dVideoLabels.jntcenters.R = {};
ref.c3dVideoLabels.jntangles.L = {};
ref.c3dVideoLabels.jntangles.R = {};
ref.c3dVideoLabels.jntmoments.L = {};
ref.c3dVideoLabels.jntmoments.R = {};
ref.c3dVideoLabels.jntpowers.L = {};
ref.c3dVideoLabels.jntpowers.R = {};

ref.emgChannels = { ...
        { 'R', 'Tibialis Anterior' },   ...
        { 'R', 'Biceps' },              ...
        { 'R', 'Erector Spinae' },      ...
        { 'R', 'Gmed' },                ...
        { 'R', 'Gmax' },                ...
        { 'R', 'Vasl' },                ...
        { 'R', 'Rectus Femoris' },      ...
        { 'R', 'Hamstrings' },          ...
        { 'R', 'Deltoids' },            ...
        { 'R', 'Gastroc' },             ...
        { 'R', 'Soleus' },              ...
        { 'L', 'Soleus' },              ...
        { 'L', 'Gastroc' },             ...
        { 'L', 'Tibialis Anterior' },   ...
        { 'L', 'Hamstrings' },          ...
        { 'L', 'Rectus Femoris' } };

ref.emgMuscleToColumnPrefix = { ...
        { 'Tibialis Anterior', 'tib_ant' },   ...
        { 'Biceps', 'bic' },              ...
        { 'Erector Spinae', 'ercspn' },      ...
        { 'Gmed', 'glut_med' },                ...
        { 'Gmax', 'glut_max' },                ...
        { 'Vasl', 'vas_lat' },                ...
        { 'Rectus Femoris', 'rect_fem' },      ...
        { 'Hamstrings', 'hams' },          ...
        { 'Deltoids', 'delts' },            ...
        { 'Gastroc', 'gas' },             ...
        { 'Soleus', 'soleus' } };

% Specify muscles corresponding to EMG reference data of interest
% for overlaying EMG on/off times reported by Perry (1992).
% NOTE:  the muscle abbreviations must correspond to those in 
%        get_emgTimingFromPerry().
ref.muscRefList{1}   = {'TA', 'EDL', 'PERlong'}; % TA
ref.muscRefList{2}   = {}; % Biceps
ref.muscRefList{3}   = {}; % ES
ref.muscRefList{4}   = {}; % Gmed
ref.muscRefList{5}   = {}; % Gmax
ref.muscRefList{6}   = {'VASlat'}; % Vasl
ref.muscRefList{7}   = {'RF', 'VASmed', 'VASint', 'VASlat'}; % RF
ref.muscRefList{8}   = {'BFLH', 'BFSH', 'SM', 'ST'}; % Hamstrings
ref.muscRefList{9}   = {}; % Deltoids
ref.muscRefList{10}  = {'GAS'}; % Gastroc
ref.muscRefList{11}  = {'SOL'}; % Soleus
ref.muscRefList{12}  = {'SOL'}; % Soleus
ref.muscRefList{13}  = {'GAS'}; % Gastroc
ref.muscRefList{14}  = {'TA', 'EDL', 'PERlong'}; % TA
ref.muscRefList{15}  = {'BFLH', 'BFSH', 'SM', 'ST'}; % Hamstrings
ref.muscRefList{16}  = {'RF', 'VASmed', 'VASint', 'VASlat'}; % RF

%ref.emgChannelsOfInterest = [10 11 12 13];
%ref.emgChannelsOfInterest = 1:length(ref.emgChannels);
ref.emgChannelsOfInterest = [ 16 7 15 8 14 1 13 10 12 11 9 6 5 4 3 2 ]; % a better ordering pairing left & right

ref.analogRate = 600;

ref.tZeroAtFirstIC = 0;

ref.muscleActPlotLabels = @ref_muscleActPlotLabelsDelaware;

return;
