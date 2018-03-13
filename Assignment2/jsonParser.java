// Generated from json.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class jsonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, STRING=8, WS=9;
	public static final int
		RULE_object = 0, RULE_array = 1, RULE_keyvalue = 2, RULE_value = 3;
	public static final String[] ruleNames = {
		"object", "array", "keyvalue", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'<'", "','", "'>'", "'['", "']'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "NUMBER", "STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "json.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public jsonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ObjectContext extends ParserRuleContext {
		public List<KeyvalueContext> keyvalue() {
			return getRuleContexts(KeyvalueContext.class);
		}
		public KeyvalueContext keyvalue(int i) {
			return getRuleContext(KeyvalueContext.class,i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_object);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(T__0);
			setState(9);
			keyvalue();
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(10);
				match(T__1);
				setState(11);
				keyvalue();
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(T__3);
			setState(22);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(20);
				object();
				}
				break;
			case T__3:
				{
				setState(21);
				array();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1 || _la==T__3) {
				{
				setState(27);
				switch (_input.LA(1)) {
				case T__1:
					{
					setState(24);
					match(T__1);
					setState(25);
					object();
					}
					break;
				case T__3:
					{
					setState(26);
					array();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyvalueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(jsonParser.NUMBER, 0); }
		public KeyvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).enterKeyvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).exitKeyvalue(this);
		}
	}

	public final KeyvalueContext keyvalue() throws RecognitionException {
		KeyvalueContext _localctx = new KeyvalueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keyvalue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(35);
			match(T__5);
			setState(36);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(jsonParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(jsonParser.NUMBER, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof jsonListener ) ((jsonListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(38);
				match(STRING);
				}
				break;
			case NUMBER:
				{
				setState(39);
				match(NUMBER);
				}
				break;
			case T__0:
				{
				setState(40);
				object();
				}
				break;
			case T__3:
				{
				setState(41);
				array();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\7\2\17\n\2\f\2\16\2\22\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\5\3\31\n\3\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5-\n\5\3\5\2\2\6\2\4\6\b\2\3\3\2\t"+
		"\n\61\2\n\3\2\2\2\4\25\3\2\2\2\6$\3\2\2\2\b,\3\2\2\2\n\13\7\3\2\2\13\20"+
		"\5\6\4\2\f\r\7\4\2\2\r\17\5\6\4\2\16\f\3\2\2\2\17\22\3\2\2\2\20\16\3\2"+
		"\2\2\20\21\3\2\2\2\21\23\3\2\2\2\22\20\3\2\2\2\23\24\7\5\2\2\24\3\3\2"+
		"\2\2\25\30\7\6\2\2\26\31\5\2\2\2\27\31\5\4\3\2\30\26\3\2\2\2\30\27\3\2"+
		"\2\2\31\37\3\2\2\2\32\33\7\4\2\2\33\36\5\2\2\2\34\36\5\4\3\2\35\32\3\2"+
		"\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37"+
		"\3\2\2\2\"#\7\7\2\2#\5\3\2\2\2$%\t\2\2\2%&\7\b\2\2&\'\5\b\5\2\'\7\3\2"+
		"\2\2(-\7\n\2\2)-\7\t\2\2*-\5\2\2\2+-\5\4\3\2,(\3\2\2\2,)\3\2\2\2,*\3\2"+
		"\2\2,+\3\2\2\2-\t\3\2\2\2\7\20\30\35\37,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}