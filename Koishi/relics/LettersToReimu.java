/*    */ package Koishi.relics;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.util.TextureLoader;
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class LettersToReimu
/*    */   extends CustomRelic {
/* 18 */   public static final String ID = KoishiMod.makeID("LettersToReimu");
/*    */   
/* 20 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("LettersToReimu.png"));
/* 21 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("LettersToReimu.png"));
/*    */   
/*    */   private static final int TEMP_HP = 2;
/*    */   
/*    */   public LettersToReimu() {
/* 26 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.UNCOMMON, AbstractRelic.LandingSound.FLAT);
/*    */   }
/*    */ 
/*    */   
/*    */   public void onExhaust(AbstractCard card) {
/* 31 */     flash();
/* 32 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, (AbstractRelic)this));
/* 33 */     AbstractPlayer p = AbstractDungeon.player;
/* 34 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new AddTemporaryHPAction((AbstractCreature)p, (AbstractCreature)p, 2));
/*    */   }
/*    */   
/*    */   public String getUpdatedDescription() {
/* 38 */     return this.DESCRIPTIONS[0] + '\002' + this.DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/LettersToReimu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */