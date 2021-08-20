import {createTheme} from "@material-ui/core";
import Palette from "./Palette";
import '@fontsource/roboto/700.css';


const appBarMargin = 15

const DefaultTheme = createTheme({
    overrides: {
        MuiContainer: {
            root: {
                backgroundColor: Palette.palette.secondary.light,
            },
            maxWidthXs: {
                marginTop: 100,
            },
            maxWidthLg: {
                marginTop: 100
            },
            maxWidthXl: {
                background: Palette.palette.primary.main,
            }
        },
        MuiTypography: {
            colorPrimary: {
                color: Palette.palette.primary.main
            },
            colorSecondary: {
                color: Palette.palette.info.main
            },
            body1: {
                textAlign: "center",
            },
            h2: {
                color: Palette.palette.info.main,
                fontFamily: "Roboto",
                fontSize: "xx-large",
                marginTop: appBarMargin,
                marginBottom: appBarMargin,
                maxWidth: "fit-content",
                transition: "all .2s ease-in-out",
                "&:hover": {
                    transform: "scale(1.05, 1.05)",
                },
            },
            h4: {
                color: Palette.palette.info.main,
                fontFamily: "Roboto",
            },
            h5: {
                color: Palette.palette.info.main,
                fontFamily: "Roboto",
            },
        },
        MuiAppBar: {
            root: {
                background: Palette.palette.primary.main
            },
            colorDefault: {
                backgroundColor: Palette.palette.primary.main
            },
            colorSecondary: {
                background: "transparent"
            }
        },
        MuiCard: {
            root: {}
        },
        MuiCardHeader: {
            root: {
                paddingBottom: 0
            },
            title: {
                color: Palette.palette.info.main,
                alignItems: "center",
            }
        },
        MuiTextField: {
            root: {
                marginBottom: 10,
            }
        },
        MuiFormLabel: {
            root: {
                color: Palette.palette.info.light,
                "&.Mui-focused": {
                    color: Palette.palette.info.main,
                }
            }
        },
        MuiInput: {
            root: {
                color: Palette.palette.info.main,
            }
        },
        MuiPickersToolbar: {
            toolbar: {
                backgroundColor: Palette.palette.primary.main
            }
        },
        MuiPickersDay: {
            daySelected: {
                backgroundColor: Palette.palette.primary.main,
                "&:hover": {
                    backgroundColor: Palette.palette.primary.dark
                }
            },
        },
        MuiPickersMonth: {
            monthSelected: {
                color: Palette.palette.primary.main
            }
        },
        MuiButton: {

            fullWidth: {
                background: Palette.palette.primary.main,
                "&:hover": {
                    backgroundColor: Palette.palette.primary.light,
                },
                "&:active": {
                    background: Palette.palette.primary.dark,
                },
                "&:focus": {
                    background: Palette.palette.primary.main,
                },
            },
            textPrimary: {
                color: Palette.palette.primary.main
            },
        },
    }
})

export default DefaultTheme