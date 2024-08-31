/*    */ package Koishi.relics;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import Koishi.util.TextureLoader;
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ 
/*    */ public class BloodstainedWhiteRose extends CustomRelic {
/* 19 */   public static final String ID = KoishiMod.makeID("BloodstainedWhiteRose");
/*    */   
/* 21 */   private static final Texture IMG = TextureLoader.getTexture(KoishiMod.makeRelicPath("BloodstainedWhiteRose.png"));
/* 22 */   private static final Texture OUTLINE = TextureLoader.getTexture(KoishiMod.makeRelicOutlinePath("BloodstainedWhiteRose.png"));
/*    */   
/*    */   private static final int TERROR = 3;
/*    */   
/*    */   public BloodstainedWhiteRose() {
/* 27 */     super(ID, IMG, OUTLINE, AbstractRelic.RelicTier.COMMON, AbstractRelic.LandingSound.MAGICAL);
/*    */   }
/*    */ 
/*    */   
/*    */   public void atBattleStart() {
/* 32 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, (AbstractRelic)this));
/* 33 */     AbstractMonster m = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
/* 34 */     AbstractPlayer p = AbstractDungeon.player;
/* 35 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new TerrorPower((AbstractCreature)m, (AbstractCreature)p, 3), 3));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 40 */     return this.DESCRIPTIONS[0] + '\003' + this.DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/relics/BloodstainedWhiteRose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */