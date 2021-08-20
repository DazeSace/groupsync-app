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
                marginTop: 100
            },
            maxWidthLg: {
                marginTop: 100
            },
            maxWidthXl: {
                background: Palette.palette.primary.main,
            }
        },
        MuiTypography: {
            h2: {
                color: Palette.palette.info.main,
                fontFamily: "Roboto",
                fontSize: "xx-large",
                marginTop: appBarMargin,
                marginBottom: appBarMargin
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
                borderColor: "aliceblue",
                marginBottom: 10
            }
        },
    }
})

export default DefaultTheme